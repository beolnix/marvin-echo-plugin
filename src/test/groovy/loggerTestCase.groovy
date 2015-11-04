import org.junit.Test
import org.apache.commons.lang.StringUtils
import org.apache.log4j.Layout
import org.apache.log4j.PatternLayout
import org.apache.log4j.Appender
import org.apache.log4j.DailyRollingFileAppender
import org.apache.log4j.Logger
import org.apache.log4j.Level
/**
 * Author: Atmakin Danila 
 * Email: datmakin@dh-lab.ru
 * Date: 29.11.11
 * Time: 14:21
 */
class loggerTestCase {

    @Test
    public void testCreateLogger() {
        String logsPath = 'test'
        if (StringUtils.isEmpty(logsPath))
            logsPath = 'logs'

        Layout layout = new PatternLayout('%d{HH:mm:ss} %-5p: %c{2}.%M() - %m%n')

        Appender appender = new DailyRollingFileAppender(layout,
                                                         "${logsPath}.log",
                                                         "'.'yyyy-MM-dd'.log'")
        Logger rootLogger = Logger.getRootLogger()
        rootLogger.setLevel(Level.DEBUG)
        rootLogger.addAppender(appender)
    }
}
