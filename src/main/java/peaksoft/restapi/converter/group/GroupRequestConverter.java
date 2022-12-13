package peaksoft.restapi.converter.group;

import org.springframework.stereotype.Component;
import peaksoft.restapi.dto.course.CourseRequest;
import peaksoft.restapi.dto.group.GroupRequest;
import peaksoft.restapi.entities.Course;
import peaksoft.restapi.entities.Group;

@Component
public class GroupRequestConverter {
    public Group createGroup(GroupRequest groupRequest){
        if (groupRequest == null){
            return null;
        }

        Group group = new Group();

        group.setGroupName(groupRequest.getGroupName());
        group.setDateOfStart(groupRequest.getDateOfStart());
        group.setImage(group.getImage());

        return group;
    }


    public void updateGroup(Group group, GroupRequest groupRequest){
        if (groupRequest.getGroupName() != null){
            group.setGroupName(groupRequest.getGroupName());
        }if (groupRequest.getDateOfStart() == null){
            group.setDateOfStart(groupRequest.getDateOfStart());
        }if (groupRequest.getImage() != null){
            group.setImage(groupRequest.getImage());
        }
    }
}

