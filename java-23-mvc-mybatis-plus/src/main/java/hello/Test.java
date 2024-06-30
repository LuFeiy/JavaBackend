package hello;

import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.InputStream;
import java.util.Properties;

public class Test {
    public static void main(String[] args) throws Exception {
        // 加载数据库配置
        //Properties props = Resources.getResourceAsProperties("database.properties");
        // 加载 MyBatis 配置
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new MybatisSqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper userMapper = session.getMapper(UserMapper.class);

            // 插入用户
            User user = new User();
            user.setName("John Doe");
            user.setAge(25);
            user.setEmail("john.doe@example.com");
            userMapper.insert(user);
            System.out.println("插入的用户ID：" + user.getId());

            // 分页查询用户
            IPage<User> userPage = new Page<>(1, 10);
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.like("name", "John");
            IPage<User> result = userMapper.selectPage(userPage, queryWrapper);
            System.out.println("总页数：" + result.getPages());
            System.out.println("总记录数：" + result.getTotal());
            result.getRecords().forEach(System.out::println);

            session.commit();
        }
    }
}
