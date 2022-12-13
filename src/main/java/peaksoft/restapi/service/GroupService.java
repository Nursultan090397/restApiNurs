package peaksoft.restapi.service;

import peaksoft.restapi.dto.group.GroupRequest;
import peaksoft.restapi.dto.group.GroupResponse;
import peaksoft.restapi.entities.Group;

import java.io.IOException;
import java.util.List;

public interface GroupService {
    List<GroupResponse> getAllListGroups();

    List<GroupResponse> getAlGroups(Long courseId);

    GroupResponse addGroup(Long id, GroupRequest groupRequest);

    GroupResponse getGroupById(Long id);

    GroupResponse updateGroup(Long id, GroupRequest groupRequest);

    GroupResponse deleteGroup(Long id);
   void assignGroup(Long courseId, Long groupId) throws IOException;
}
