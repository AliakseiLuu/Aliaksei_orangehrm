package entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Job {
  private final String jobTitleField;
  private final String jobDescriptionField;
  private final String jobAddNoteField;
}
