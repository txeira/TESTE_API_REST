
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;
import org.junit.Test;


public class Teste_API_Postman {

    @Test
    public void Teste() {
    String uriBase = "https://postman-echo.com/get";

    given()
        .relaxedHTTPSValidation()
        .param("foo", "bar")
    .when()
        .get(uriBase)
    .then()
        .statusCode(200) // Verifica se o status retornado foi 200
        .contentType(ContentType.JSON) // Verifica se o response retornado esta formato JSON
        .body("headers.host", is("postman-echo.com")) // Verifica se a chave "host" possui exatamente o valor "postman-echo.com"
        .body("args.foo", containsString("bar")) // Verifica se a chave "foo" contém o valor "bar"
        .body( "headers.x-forwarded-proto", containsString("http")); // Verifica se a chave "x-forwarded-proto" contém o valor "http"
    }
}
