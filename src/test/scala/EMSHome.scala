import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class EMSHome extends Simulation {

  val scn = scenario("EMS Scenario")
    .exec(http("Home Page")
      .get("http://172.27.59.18:8085/EmployeeApplication/home.htm"))
    .pause(10)
    .exec(http("request_add")
      .post("http://172.27.59.18:8085/EmployeeApplication/jsp/add.htm")
      .param("""code""", """1""")
      .param("""name""", """a""")
      .param("""city""", """b"""))
    .pause(1)
    .exec(http("request_edit")
      .get("http://172.27.59.18:8085/EmployeeApplication/edit.jsp?code=1&name=a&city=a"))
    .pause(1)
    .exec(http("request_edit submit")
      .post("http://172.27.59.18:8085/EmployeeApplication/edit.htm")
      .param("""code""", """1""")
      .param("""name""", """b""")
      .param("""city""", """c"""))
    .pause(1)
    .exec(http("request_delete")
      .get("http://172.27.59.18:8085/EmployeeApplication/delete.jsp?code=1"))
    .pause(10)
    .exec(http("request_delete submit")
      .post("http://172.27.59.18:8085/EmployeeApplication/delete.htm")
      .param("""code""", """1"""))

  setUp(scn.inject(ramp(10 users) over (2 seconds)))
}