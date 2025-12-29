package entities;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Job {
  private final String jobTitleField;
  private final String jobDescriptionField;
  private final String jobAddNoteField;
}
