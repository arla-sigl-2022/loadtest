package garlaxy

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._
import scala.util.Random

case class LoadtestEnvironmentVariableException(private val message: String = "",
                                                private val cause: Throwable = None.orNull) extends Exception(message, cause)


class ContractorSimulation extends Simulation {

  @throws(classOf[LoadtestEnvironmentVariableException])
  def getEnvOrThrow(name: String): String = {
    val env = System.getenv(name)
    if (env != null) env else throw LoadtestEnvironmentVariableException(s"missing env var ${name}")
  }

  val backendUrl: String = getEnvOrThrow("LOADTEST_BACKEND_URL")
  val frontendUrl: String = getEnvOrThrow("LOADTEST_FRONTEND_URL")
  val constantConcurrentUsersNumber: String = getEnvOrThrow("LOADTEST_CONSTANT_CONCURRENT_USERS")
  val loadtestDuration: String = getEnvOrThrow("LOADTEST_DURATION")

  val contractorSeq: Seq[String] = Seq(
    "ATG Europe",  "Telespazio VEGA UK",
  "Leafspace",
  "Oxford Space Systems",
  "Zero 2 Infinity",
  "EUMETSAT",
  "Solenix GmbH",
  "ISIS - Innovative Solutions In Space",
  "Rippleaerospace",
  "SpaceVR",
  "Gilmour Space Technologies",
  "GMV",
  "AKKA Technologies",
  "Deimos Imaging",
  "Astrobotic Technology Inc.",
  "Vector",
  "QinetiQ Space",
  "DLR GfR mbH",
  "Atlas Space Operations",
  "ispace EUROPE S.A.",
  "Infostellar",
  "CALLISTO",
  "SkyWatch",
  "Mynaric USA",
  "Neptec Design Group Ltd.",
  "GomSpace",
  "Spire",
  "Sky and Space Global",
  "PLD Space",
  "Loft Orbital",
  "University of Luxembourg",
  "European GNSS Agency",
  "HCCR K.K.",
  "ICEYE",
  "AstroAgency",
  "Stellar Amenities",
  "Bradford Deep Space Industries",
  "MethaneSAT LLC",
  "GAF AG",
  "The University of Auckland",
  "DLR - German Aerospace Center",
  "Advanced Computer Systems ACS-D GmbH",
  "Stealth Startup",
  "Space Talos LTD",
  "Agnikul Cosmos",
  "University College London/ Mullard Space Science Laboratory",
  "Absolut System",
  "S.A.B. Aerospace s.r.o.",
  "VEOWARE SPACE",
  "Bitpanda",
  "Infostellar",
  "EMSISTI Space Systems & Tecnology",
  "Officina Stellare",
  "Luxembourg Institute of Science and Technology",
  "Made In Space Europe",
  "Thales Alenia Space UK",
  "LIST",
  "ONERA",
  "University College London",
  "adksmksamd aksmdksamda kmskad",
  "LiveEO",
  "ODYSSEUS Space",
  "Berlin Space Technologies",
  "Kepler Communications",
  "Vitrociset Belgium",
  "Progressive Systems",
  "Micro IT",
  "Delta System Solutions GmbH",
  "Audacy",
  "Spaceflight",
  "Lilium",
  "OQ TECHNOLOGY",
  "Telespazio Germany GmbH",
  "SpaceKnow Inc.",
  "CBK PAN",
  "ICEYE",
  "Deep Space Industries",
  "VisionSpace Technologies GmbH",
  "OHB-System AG",
  "Space Individuals",
  "Honeybee Robotics",
  "Analytical Space",
  "WGS Workgroup Solutions GmbH",
  "Spire",
  "Rocket Lab",
  "UbiquitiLink Inc",
  "STFC",
  "TTTech Computertechnik AG",
  "Maana Electric",
  "IMMEDIA",
  "Nitrexo",
  "OneWeb",
  "AGC",
  "Gooch & Housego",
  "Dinamico Aerospace",
  "We are Quattro",
  "CERN",
  "Terma Group",
  "Space Impulse",
  "EUMETSAT",
  "T4i Technology for Propulsion and Innovation Srl",
  "Adamant Composites",
  "Philotech Systementwicklung und Software GmbH",
  "HyImpulse Technologies GmbH",
  "GMV",
  "HE Space",
  "Sitec a Belcan Company",
  "Cosmic Futures",
  "Space Applications Services NV/SA",
  "Blue Skies Space",
  "Serco Europe",
  "RHEA Group",
  "Spacedarts",
  "Morehead State University",
  "FENTISS",
  "VHR",
  "Space Talos Ltd.",
  "Celestia Technologies Group (CTG)",
  "Malin Space Science Systems",
  "Pixxel",
  "QSR Consulting",
  "Kongsberg Defence & Aerospace; Space & Surveillance Division",
  "Swedish Space Corporation",
  "ASYSOL S.L",
  "CGI Deutschland",
  "Open Cosmos",
  "Spaceopal",
  "Spire Global",
  "LSE Space GmbH",
  "B2Space",
  "NEXT Ingegneria dei Sistemi",
  "ThrustMe",
  "VESTA SPACE TECHNOLOGY PVT LTD",
  "European Space Agency - ESA",
  "Hydrosat",
  "TU Braunschweig - Institute  of Space Systems",
  "a.i. solutions, Inc.",
  "Technische Universität Dresden",
  "Hochschule Bremen",
  "Sen",
  "Kythera Space Solutions",
  "Deimos Space",
  "Breakthrough Initatives",
  "AH Executives AB",
  "AD AIR CENTRE",
  "Grey consultants",
  "Sky and Space Global",
  "OIP Sensor Systems",
  "Space Products and Innovation",
  "Politecnico di Milano",
  "Airbus Defence and Space",
  "SRON Netherlands Institute for Space Research",
  "Skyroot Aerospace Private Limited",
  "Celestia Portugal")

  def getRandomContractor: String = {
    val rand = new Random
    contractorSeq(rand.nextInt(contractorSeq.length))
  }

  private val httpProtocol = http
    .baseUrl(frontendUrl)
    .inferHtmlResources(AllowList(), DenyList())
    .acceptHeader("*/*")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .originHeader(frontendUrl)
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:95.0) Gecko/20100101 Firefox/95.0")
  
  private val headers_0 = Map(
  		"Cache-Control" -> "no-cache",
  		"Pragma" -> "no-cache"
  )
  
  private val headers_1 = Map(
  		"Access-Control-Request-Headers" -> "content-type",
  		"Access-Control-Request-Method" -> "GET",
  		"Cache-Control" -> "no-cache",
  		"Pragma" -> "no-cache"
  )
  
  private val headers_2 = Map(
  		"Cache-Control" -> "no-cache",
  		"Content-Type" -> "application/json",
      "Origin" -> frontendUrl,
  		"Pragma" -> "no-cache"
  )
  
  private val headers_3 = Map(
  		"Access-Control-Request-Headers" -> "content-type",
  		"Access-Control-Request-Method" -> "POST",
  		"Cache-Control" -> "no-cache",
  		"Pragma" -> "no-cache"
  )


  private val scn = scenario("ContractorSimulation")
    .exec(
      http("Get Resources")
        .get(s"${backendUrl}/v1/resource?page=1&limit=10")
        .headers(headers_0)
    )
    .pause(2)
    .exec(
      http("Get contractors OPTION")
        .options(s"${backendUrl}/v1/contractor")
        .headers(headers_1)
        .resources(
          http("Get contractors GET")
            .get(s"${backendUrl}/v1/contractor")
            .headers(headers_2)
        )
    )
    .pause(2)
    .exec(
      http("Get contractor comments OPTIONS")
        .options(s"${backendUrl}/v1/contractor/comment?page=1&limit=5")
        .headers(headers_3)
        .resources(
          http("Get contractor comments POST")
            .post(s"${backendUrl}/v1/contractor/comment?page=1&limit=5")
            .headers(headers_2)
            .body(StringBody(s"""{"contractor":"$getRandomContractor"}"""))
        )
    )



	setUp(
    scn.inject(
      constantConcurrentUsers(constantConcurrentUsersNumber.toInt) during (loadtestDuration.toInt minutes))
      .protocols(httpProtocol))
}
