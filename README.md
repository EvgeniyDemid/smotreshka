# Проект по автоматизации тестирования для компании [ЛАЙФСТРИМ](https://smotreshka.tv/)

> ЛАЙФСТРИМ — разрабатывает качественные решения для интернет-телевидения и онлайн-кинотеатров.

## **Содержание:**

____

* <a href="#tools">Технологии и инструменты</a>

* <a href="#cases">Примеры автоматизированных тест-кейсов</a>

* <a href="#jenkins">Сборка в Jenkins</a>

* <a href="#console">Запуск из терминала</a>

* <a href="#allure">Allure отчет</a>

* <a href="#allure_testops">Allure_testops отчет</a>

* <a href="#telegram">Уведомление в Telegram при помощи бота</a>

* <a href="#video">Примеры видео выполнения тестов на Selenoid</a>



____
<a id="tools"></a>

## <a name="Технологии и инструменты">**Технологии и инструменты:**</a>

<p align="center">  
<a href="https://www.jetbrains.com/idea/"><img src="images/logo/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA"/></a>  
<a href="https://www.java.com/"><img src="images/logo/Java.svg" width="50" height="50"  alt="Java"/></a>  
<a href="https://github.com/"><img src="images/logo/Github.svg" width="50" height="50"  alt="Github"/></a>  
<a href="https://junit.org/junit5/"><img src="images/logo/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a>  
<a href="https://gradle.org/"><img src="images/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>  
<a href="https://selenide.org/"><img src="images/logo/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>
<a href="https://qameta.io/"><img src="images/logo/Allure2.svg" width="50" height="50"  alt="Allure TestOps"/></a>   
<a href="https://www.jenkins.io/"><img src="images/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>  
<a href="https://www.jenkins.io/"><img src="images/logo/Allure_Testops.svg" width="50" height="50"  alt="Jenkins"/></a>  
</p>

____
<a id="cases"></a>

## <a name="Примеры автоматизированных тест-кейсов">**Примеры автоматизированных тест-кейсов:**</a>

____

- ✓ *Проверка перехода на страницу авторизации*
- ✓ *Проверка перехода на страницу регисрации*
- ✓ *Проверка перехода на страницу Смотреть ТВ*
- ✓ *Проверка перехода на страницу Кино*
- ✓ *Проверка перехода на страницу Кинотеатр*
- ✓ *Проверка перехода на страницу На Smart TV*
- ✓ *Проверка перехода на страницу О Смотрёшке*
- ✓ *Добавление каналов в избранное*
- ✓ *Поиск каналов*
- ✓ *Проверка данных полученных по API*

____
<a id="jenkins"></a>

## <img alt="Jenkins" height="25" src="images/logo/Jenkins.svg" width="25"/></a><a name="Сборка"></a>Сборка в [Jenkins](https://jenkins.autotests.cloud/job/c20-DemidofE-lesson15-my-test-project/)</a>

____
<p align="center">  
<a href="https://jenkins.autotests.cloud/job/c20-DemidofE-Diplom-Project/"><img src="images/screen/jenkins_build.png" alt="Jenkins" width="950"/></a>  
</p>

### **Параметры сборки в Jenkins:**

- *browser (браузер, по умолчанию chrome)*
- *browserVersion (версия браузера, по умолчанию 100.0)*
- *browserSize (размер окна браузера, по умолчанию 1920x1080)*
- *baseUrl (адрес тестируемого веб-сайта)*
- *remoteUrl (логин, пароль и адрес удаленного сервера Selenoid)*

<a id="console"></a>

## Команды для запуска из терминала

___
***Локальный запуск:***
(Для запуска необходимо зарегистироваться на https://smotreshka.tv/)

```bash  
gradle clean test -Demail={EMAIL} -Dpassword={PASSWORD}
```

***Удалённый запуск с параметрами***

```bash  
clean {TASK}
"-DurlApi=${URL_API}"
"-DisRemote=true"
"-DbaseUrl=${BASE_URL}"
"-DbrowserSize=${BROWSER_SIZE}"
"-Dbrowser=${BROWSER}"
"-Dselenoid=${SELENOID}"
"-DbrowserVersion=${BROWSER_VERSION}"
```

***Параметры запуска:***

* <code>TASK</code> – Запускаемые автотесты (ui,api,test).
* <code>BASE_URL</code> – Url, по которому будет открываться тестируемое приложение.
* <code>BROWSER_SIZE</code> – размер окна браузера, в котором будут выполняться тесты. По-умолчанию - <code>
  1920x1080</code>.
* <code>BROWSER</code> – браузер, в котором будут выполняться тесты. По-умолчанию - <code>chrome</code>.
* <code>SELENOID</code> – адрес удаленного сервера, на котором будут запускаться тесты.
* <code>BROWSER_VERSION</code> – версия браузера, в которой будут выполняться тесты. По-умолчанию - <code>100.0</code>.
* <code>URL_API</code> - url для API запросов

___
<a id="allure"></a>

## <img alt="Allure" height="25" src="images/logo/Allure.svg" width="25"/></a> <a name="Allure"></a>Allure [отчет](https://jenkins.autotests.cloud/job/c20-DemidofE-Diplom-Project/8/allure/)</a>

___

### *Основная страница отчёта*

<p align="center">  
<img title="Allure Overview Dashboard" src="images/screen/jenkins.png" width="850">  
</p>  

### *Тест-кейсы*

<p align="center">  
<img title="Allure Tests" src="images/screen/jenkins_tests.png" width="850">  
</p>

### *Графики*

  <p align="center">  
<img title="Allure Graphics" src="images/screen/allure_graths.png" width="850">

</p>

___
<a id="allure_testops"></a>

## <img alt="Allure" height="25" src="images/logo/Allure_Testops.svg" width="25"/></a> <a name="Интеграция с Allure TestOps"></a>Интеграция с Allure TestOps [Dashboard](https://allure.autotests.cloud/project/3621/dashboards)</a>

#### Dashboard
<p align="center">
<img title="Jenkins Build" src="images/screen/AllureTestOps.png">
</p>

#### Тест-кейсы в Allure TestOps
<p align="center">
<img title="Jenkins Build" src="images/screen/allureTestOpsCase.png">
</p>
____
<a id="telegram"></a>

## <img alt="Allure" height="25" src="images/logo/Telegram.svg" width="25"/></a> Уведомление в Telegram при помощи бота

____
<p align="center">  
<img title="Allure Overview Dashboard" src="images/screen/telegram.png" width="550">  
</p>


____
<a id="video"></a>

## <img alt="Selenoid" height="25" src="images/logo/Selenoid.svg" width="25"/></a> Примеры видео выполнения тестов на Selenoid

____
<p align="center">
<img title="Selenoid Video" src="images/video/cinema.gif" width="550" height="350"  alt="video">   
</p>

