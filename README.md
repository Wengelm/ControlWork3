# ControlWork3
В зависимости от варианта предусмотрено 2 вида программ:
а) создание приложений архитектуры «клиент-сервер», взаимодействующих по протоколу TCP/IP;
б) разработка клиент-серверных приложений с использованием протокола UDP.

Требования:

приложение на Java в архитектуре клиент-сервер с использованием протокола TCP или UDP (в зависимости от варианта).

1) На базе приведенного примера (смотреть документ “ Методические указания к заданию 3 – TCP”) разработать приложение, позволяющее осуществлять взаимодействие клиента и сервера по совместному решению задач обработки информации. Протокол взаимодействия – TCP. Приложение клиента должно иметь GUI-интерфейс, показанный на рис. 2.3. в методическом пособии. Приложение сервера можно оставить в консольной реализации. Сервер должен предоставлять возможность последовательного установления соединения с клиентами (как это реализовано в примере).

2) Разработать приложение на основе UDP-соединения, позволяющее осуществлять взаимодействие клиента и сервера по совместному решению задач обработки информации (смотреть документ “Методические указания к заданию 3 – UDP”). Приложение должно располагать возможностью передачи и модифицирования получаемых (передаваемых) данных. Клиент должен быть реализован в виде GUI интерфейса на базе JavaFX. Возможности клиента: передать серверу исходные параметры (число а, число b и число с вводятся с клавиатуры) для расчета значения функции, а также получить расчетное значение функции. Возможности сервера: по полученным от клиента исходным параметрам рассчитать сумму первого ряда от а до b и сумму второго ряда от b до с. Расчет первой и второй сумм осуществляется в разных потоках.
