package com.saymeevetime;

/**
 *
 * @author jiacheng
 * @date 28/8/25 21:20 Thursday
 * @description :
 *
 */
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.community.model.dashscope.WanxImageModel;
import dev.langchain4j.data.image.Image;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.output.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class LLMTest {

    /**
     * * gpt-4o-mini语言模型接入测试
     */
    @Test
    public void testGPTDemo() {
        //初始化模型
        OpenAiChatModel model = OpenAiChatModel.builder()

                //LangChain4j提供的代理服务器，该代理服务器会将演示密钥替换成真实密钥， 再将请求转发给OpenAI API

                .baseUrl("https://dashscope.aliyuncs.com/compatible-mode/v1") //设置模型api地址（如，则可省略baseUrl的配置）
                .apiKey("sk-9ab0b38d8e054d0b8fc197082aaef3ff")     //设置模型apiKey
                .modelName("qwen-plus-latest")  //设置模型名称
                .build();


        //向模型提问
        String answer = model.chat("你好");
        //输出结果
        System.out.println(answer);

    }

    @Autowired
    OpenAiChatModel openAiChatModel;

    @Test
    public void testSpringboot(){
        // 向模型提问
        String answer = openAiChatModel.chat("您好");
        System.out.println(answer);
    }


    /**
     *   通义千问大模型
     */

    @Autowired
    private QwenChatModel qwenChatModel;
    @Test
    public void testDashScopeQwen() {
        //向模型提问
        String answer = qwenChatModel.chat("你好");
        //输出结果
        System.out.println(answer);
    }



    @Test
    public void testDashScopeWanx() {
        WanxImageModel wanxImageModel = WanxImageModel.builder()
                .modelName("wanx2.1-t2i-plus")
                .apiKey(System.getenv("DASHSCOPE_API_KEY"))
                .build();

        String prompt = """
            奇幻森林精灵：在一片弥漫着轻柔薄雾的古老森林深处，阳光透过茂密枝叶洒下金色光斑。
            一位身材娇小、长着透明薄翼的精灵少女站在一朵硕大的蘑菇上。
            她有着海藻般的绿色长发，发间点缀着蓝色的小花，皮肤泛着珍珠般的微光。
            身上穿着由翠绿树叶和白色藤蔓编织而成的连衣裙，手中捧着一颗散发着柔和光芒的水晶球。
            周围环绕着五彩斑斓的蝴蝶，脚下是铺满苔藓的地面，蘑菇和蕨类植物丛生，营造出神秘而梦幻的氛围。
            """;

        Response<Image> response = wanxImageModel.generate(prompt);
        System.out.println(response.content().url());
    }
}