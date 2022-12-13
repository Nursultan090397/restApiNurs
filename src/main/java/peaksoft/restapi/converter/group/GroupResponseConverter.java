package peaksoft.restapi.converter.group;

import org.springframework.stereotype.Component;
import peaksoft.restapi.dto.course.CourseResponse;
import peaksoft.restapi.dto.group.GroupResponse;
import peaksoft.restapi.entities.Course;
import peaksoft.restapi.entities.Group;

import java.util.ArrayList;
import java.util.List;

@Component
public class GroupResponseConverter {
    public GroupResponse viewGroup(Group group){
        if (group==null){
            return null;
        }

        GroupResponse groupResponse = new GroupResponse();

        groupResponse.setId(group.getId());
        groupResponse.setGroupName(group.getGroupName());
        groupResponse.setDateOfStart(group.getDateOfStart());
        groupResponse.setImage(group.getImage());

        return groupResponse;
    }

    public List<GroupResponse> view(List<Group> groups){
        List<GroupResponse> groupResponses = new ArrayList<>();

        for (Group group: groups) {
            groupResponses.add(viewGroup(group));
        }

        return  groupResponses;
    }
}
