package automatizado.test;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Esta classe tem como objetivo ser uma classe base para todas as outras classes de teste, ela contém os métodos principais que todas as demais classes de teste vão precisar ter.

Ela é uma classe que só deve ser herdada e não instanciada, por isso elá é abstract.
 */

public abstract class BaseTest {  
    
    protected static WebDriver driver; //protegido, os filhos poderão acessar, possam acessar, poderia ser publico tambem
    private static final String URL_BASE = "https://www.google.com/";  //caminho do site que iremos testar
    private static final String CAMINHO_DRIVER ="src/test/java/automatizado/resource/chromedriver-v104.0.5112.79.exe"; //caminho do webdriver, Botão direito no arquivo webdriver copiar caminho relativo 

 
    @BeforeClass //BEFORE CLASS SIGNIFICA QUE SERÁ RODADO ESSA CLASSE PRIMEIRO, ANTES DE TODOS OS TESTES SEREM EXECUTADOS
    public static void iniciar(){

        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
        driver = new ChromeDriver();  //Abrindo o navegador, criando instancia
        driver.manage().window().maximize(); // NAVEGADOR ABRIR MAXIMIZADO
        driver.get(URL_BASE); // mandando navegador para essa url
    }

    @AfterClass    //AFTER CLASS SIGNIFICA QUE SERÁ RODADO ESSA CLASSE APÓS TODOS OS TESTES SEREM EXECUTADOS
    public static void finalizar(){ //protect para que os filhos possam acessar, poderia ser publico tambem
        driver.quit();
    }

}
