package com.learning.taskmanager.tasks.dtos;

import lombok.Data;
import java.util.Date;

//lombok create getter & setter after adding @Getter & @Setter annotation
//@Data equivalent to @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode.
@Data
public class CreateTaskDTO {
    Integer id;
    String name;
    Date dueDate;
    Boolean completed;
}
