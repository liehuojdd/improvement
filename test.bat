set selenium_server_path=%~dp0\driver\selenium-server-standalone-3.5.3.jar
set host_url=http://nltc178:4444/grid/register
set chrome_driver_path="%~dp0\driver\chromedriver.exe"
set firefox_driver_path="%~dp0\driver\geckodriver.exe"
set edge_driver_path="%~dp0\driver\MicrosoftWebDriver.exe"
set ie_driver_path="%~dp0\driver\IEDriverServer.exe"
set chrome_driver_port=5556
set firefox_driver_port=6666
set edge_driver_port=7777
set ie_driver_port=8888
start java -jar %selenium_server_path% -role hub
start java -Dwebdriver.chrome.driver=%chrome_driver_path% -jar %selenium_server_path% -role webdriver -hub %host_url% -port %chrome_driver_port% -browser browserName=chrome
rem start java -Dwebdriver.gecko.driver=%firefox_driver_path% -jar %selenium_server_path% -role webdriver -hub %host_url% -port %firefox_driver_port% -browser browserName=firefox
rem start java -Dwebdriver.edge.driver=%edge_driver_path% -jar %selenium_server_path% -role webdriver -hub %host_url% -port %edge_driver_port% -browser browserName="MicrosoftEdge"
rem start java -Dwebdriver.ie.driver=%ie_driver_path% -jar %selenium_server_path% -role webdriver -hub %host_url% -port %ie_driver_port% -browser browserName="internet explorer"