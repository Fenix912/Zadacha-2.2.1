package hiber.model;

import javax.persistence.*;

@Entity // Данная вннотация готоворит о том, что данный класс будет отображен в базе данных
@Table(name="cars") // Прописываем с какой таблицей будем связаны
public class Car {
    @Id // данный солбец будет в таблице праймариКей
    @GeneratedValue(strategy = GenerationType.IDENTITY) // описывает стратегию по генерации значения ПраймериКей
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;

    @OneToOne (mappedBy = "car")
    private User user;


    public Car(String model, int series){
        this.model=model;
        this.series=series;
    }

    public Car() {

    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", series=" + series +
                '}';
    }
}
