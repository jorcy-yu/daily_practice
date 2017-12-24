package testcase;

import static io.restassured.RestAssured.*;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
public class interfacetest {

    @Test
    public void test1(){

        given().param("ie","utf-8")
                .param("f","3")
                .param("rsv_bp","0")
                .param("rsv_idx","1")
                .param("tn","baidu")
                .param("wd","1")
                .param("rsv_pq","ffde21ca00025f0b")
                .param("rsv_t","accdGze9Zge5ueKY0YUCs%")
                .get("http://www.baidu.com/s")
                .then().log().all().body("html.head.title",equalTo("1_百度搜索"));
    }

}
