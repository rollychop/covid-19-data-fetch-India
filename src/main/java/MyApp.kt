import com.google.gson.Gson
import data.Constants.USER_AGENT
import data.CovidCases
import org.jsoup.Jsoup
import utils.Utils.getCurrentDate
import utils.Utils.getCurrentTime
import utils.Utils.createFile
import utils.Utils.writeToFile


fun main() {
    val doc = Jsoup.connect("https://www.mygov.in/covid-19")
            .userAgent(USER_AGENT)
            .get()
    val covidCases = mutableListOf<CovidCases>()
    val dateTime = doc.select(".information_row > .info_title > span").text()
    var mDate = dateTime.substring(dateTime.indexOf(":") + 1, dateTime.indexOf(","))
    var mTime = dateTime.substring(dateTime.indexOf(",") + 1)
    if (mDate.isEmpty() && mTime.isEmpty()) {
        mDate = getCurrentDate()
        mTime = getCurrentTime()
    }
    val elements = doc.select("table > tbody > tr")
    for (e in elements) {
        val el = e.select("td")
        covidCases.add(CovidCases(
                el[0].text(),
                el[1].text(),
                el[2].text(),
                el[3].text(),
                el[4].text(),
                mDate,
                mTime
        ))
    }
    val fileName = "covid_19_cases_as_per_${getCurrentDate()}.json"
    println(createFile(fileName))
    println(writeToFile(fileName, Gson().toJson(covidCases)))
}