# Basic Java Tasks — Gradle + JUnit

Домашнее задание по теме «Gradle и JUnit».

## Структура

- `src/main/java/BasicJavaTasks.java` — 12 методов из ДЗ по базовой Java.
- `src/test/java/BasicJavaTask1Test.java` — тесты для задачи 1.
- `src/test/java/AllBasicJavaMethodsTest.java` — запуск и проверка всех 12 методов.
- `build.gradle` — Gradle-конфигурация и связанные задачи.
- `settings.gradle` — имя проекта.

## Запуск

```bash
./gradlew testRunFinished
```

На Windows:

```text
gradlew.bat testRunFinished
```

Задача `testRunFinished` запускает `runAllTests`, которая запускает стандартную Gradle-задачу `test`. После завершения выводится `Test run is over`.

Для проекта используется Java 17.
