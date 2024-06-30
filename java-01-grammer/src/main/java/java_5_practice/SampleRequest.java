package java_5_practice;

public class SampleRequest {
    public static void main(String[] args) {
        String serviceURL = "http://mt.cn-hangzhou.aliyuncs.com/api/translate/web/general";
        String accessKeyId = "LTAI5tKZpRyLPaKtb3K7EGKF";// 使用您的阿里云访问密钥 AccessKeyId
        String accessKeySecret = "YqKyFOsjDc5xuRftXgqQ51Ozpi3FVb"; // 使用您的阿里云访问密钥
        String postBody = "{\n" +
                " \"FormatType\": \"text\",\n" +
                " \"SourceLanguage\": \"zh\",\n" +
                " \"TargetLanguage\": \"en\",\n" +
                " \"SourceText\": \"大疆无人机\",\n" +
                " \"Scene\": \"title\"\n" +
                "}";
        // Sender代码请参考帮助文档“签名方法”
        String result =  Sender.sendPost(serviceURL, postBody, accessKeyId, accessKeySecret);
        System.out.println(result);
    }
}
