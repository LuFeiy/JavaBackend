package hello;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;


public interface UserMapper extends BaseMapper<User> {
    // 所有的 CRUD 操作已经通过 BaseMapper 提供
}
