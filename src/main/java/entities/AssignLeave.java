package entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AssignLeave {

  private final String employeeName;
  private final String leaveType;
  private final String fromDate;
  private final String toDate;
  private final String partialDays;
  private final String duration;
  private final String comments;
}
