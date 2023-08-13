package acetoys.checkout;

import acetoys.simulation.TestPopulation;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import static io.gatling.javaapi.core.CoreDsl.AllowList;
import static io.gatling.javaapi.core.CoreDsl.DenyList;
import static io.gatling.javaapi.http.HttpDsl.http;

public class CheckoutSimulation extends Simulation {

  private static final String TEST_TYPE = System.getProperty("TEST_TYPE", "INSTANT_USERS");

  private static final String DOMAIN = "acetoys.uk";

  private HttpProtocolBuilder httpProtocol = http
    .baseUrl("https://" + DOMAIN)
    .inferHtmlResources(AllowList(), DenyList(".*\\.js", ".*\\.css", ".*\\.gif", ".*\\.jpeg", ".*\\.jpg", ".*\\.ico", ".*\\.woff", ".*\\.woff2", ".*\\.(t|o)tf", ".*\\.png", ".*detectportal\\.firefox\\.com.*"))
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.9");


  {
    if (TEST_TYPE.equals("INSTANT_USERS")) {
      setUp(TestPopulation.instantUsers).protocols(httpProtocol);
    } else if (TEST_TYPE.equals("RAMP_USERS")) {
      setUp(TestPopulation.rampUsers).protocols(httpProtocol);
    } else if (TEST_TYPE.equals("COMPLEX_INJECTION")) {
      setUp(TestPopulation.complexInjection).protocols(httpProtocol);
    } else if (TEST_TYPE.equals("CLOSED_MODEL")) {
      setUp(TestPopulation.closedModel).protocols(httpProtocol);
    } else {
      setUp(TestPopulation.instantUsers).protocols(httpProtocol);
    }
  }
}
