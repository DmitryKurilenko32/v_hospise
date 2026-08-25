## Процедура запуска автотестов

# Автотесты запускаются при помощи команд ADB в терминале:

тесты страницы AuthorizationPage: adb shell am instrument -w -m    -e debug false -e class 'ru.iteco.fmhandroid.ui.tests.AuthorizationTest' ru.iteco.fmhandroid.test/androidx.test.runner.AndroidJUnitRunner

тесты страницы AboutPage: adb shell am instrument -w -m    -e debug false -e class 'ru.iteco.fmhandroid.ui.tests.AboutPageTest' ru.iteco.fmhandroid.test/androidx.test.runner.AndroidJUnitRunner

тесты страницы ControlPanelPage: adb shell am instrument -w -m    -e debug false -e class 'ru.iteco.fmhandroid.ui.tests.ControlPanelTest' ru.iteco.fmhandroid.test/androidx.test.runner.AndroidJUnitRunner

тесты страницы NewsPage: adb shell am instrument -w -m    -e debug false -e class 'ru.iteco.fmhandroid.ui.tests.NewsPageTest' ru.iteco.fmhandroid.test/androidx.test.runner.AndroidJUnitRunner

тесты страницы MainPage: $ adb shell am instrument -w -m    -e debug false -e class 'ru.iteco.fmhandroid.ui.tests.MainPageTest' ru.iteco.fmhandroid.test/androidx.test.runner.AndroidJUnitRunner

## для отчета о тестировании используется отчёт Allure:

1 в корень проeкта экспортировать папку "allure-results" с генерированными файлами Allure из файлов приложения на эмуляторе,
2 находясь в корне проекта выполнить команду в терминале allure serve