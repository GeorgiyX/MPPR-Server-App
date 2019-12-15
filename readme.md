### Это сервер для ЛР1,2 по МППР
Принимает данные от клиента с предпочитаемыми характеристиками CPU, и, используя алгоритмы ML дает ответ - модель CPU.
***
#### API:
* POST: `/api/predict_cpu`

    Передаем *JSON*, примерного формата:
    ```
    {
        "Vertical_Segment" : "Mobile", 
        "Status" : "Launched", 
        "Launch_Date" : "Q3'16", 
        "Lithography" : 14.0, # От 22 до 250 без десятичных
        "nb_of_Cores" : 70.0,  # 1 - 72
        "Processor_Base_Frequency" : 1.3, #Нужно в приложухе сделать конвертр из MHz в GHz (внутренний)
        "Cache" : 4.0, 
        "TDP" : 4.5,
        "T" : 10,
        "Intel_Virtualization_Technology" : "Yes",
        "Intel_Turbo_Boost_Technology" : "2.0",
        "Embedded_Options_Available" : "No"
    }
    ```

* GET: `/`
  
  Hellow word message :)
