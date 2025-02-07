package ru.tserk.coursach.coursach.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id")
    private int feedback_id;

    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "item_id")
    private Item item_id;

    @NotEmpty(message = "Оценка обязательно должна быть заполнена")
    @Min(value = 0 , message = "Оценка не может быть меньше 0")
    @Max(value = 5, message = "Оценка не может быть больше 5")
    @Column(name = "evaluation")
    private int evaluation;

    @Column(name = "feedback_text")
    private String feedback_text;

    @Column(name = "feedback_status")
    private String feedback_status;
}
