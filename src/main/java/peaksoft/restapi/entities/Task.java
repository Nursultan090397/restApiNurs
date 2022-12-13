package peaksoft.restapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.CascadeType.REFRESH;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_gen")
    @SequenceGenerator(name = "task_gen", sequenceName = "task_gen", allocationSize = 1)
    private Long id;

    @Column(length = 100000,name = "task_name")
    private String taskName;
    @Column(length = 100000,name = "task_text")
    private String taskText;
    @Column(length = 100000,name = "task_deadline")
    private LocalDate deadline;

    @ManyToOne(cascade = {MERGE,DETACH,PERSIST,REFRESH},fetch = FetchType.EAGER)
    private Lesson lesson;
}
