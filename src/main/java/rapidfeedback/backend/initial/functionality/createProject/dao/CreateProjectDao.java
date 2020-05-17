package rapidfeedback.backend.initial.functionality.createProject.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import rapidfeedback.backend.initial.model.CreateProject;
import rapidfeedback.backend.initial.model.Project;


/**
 * @author wmn
 * @date 02/05/2020
 */

@Mapper
@Repository
public interface CreateProjectDao {

    @Insert("INSERT INTO project(subject_code, subject_name, proj_name, duration_min, duration_sec, is_group, proj_description) " +
            "VALUES(#{project.subject_code},#{project.subject_name},#{project.proj_name},#{project.duration_min},#{project.duration_sec},#{project.is_group},#{project.proj_description})")
    @Options(useGeneratedKeys = true, keyProperty = "project.id")
    Integer createProject(@Param("project") Project project);

    @Insert("INSERT INTO marker_in_proj(marker_id, proj_id) VALUES(#{markerId}, #{projectId})")
    void linkMarkerAndProj(@Param("markerId") Integer markerId, @Param("projectId") Integer projectId);

    @Insert("INSERT INTO proj_criteria(proj_id, criteria_id, weight) " +
            "VALUES(#{projectId}, 1, 0), (#{projectId}, 2, 0), (#{projectId}, 3, 0), " +
            "(#{projectId}, 4, 0), (#{projectId}, 5, 0), (#{projectId}, 6, 0), (#{projectId}, 7, 0)")
    void linkProjAndCriteria(@Param("projectId") Integer projectId);

}
