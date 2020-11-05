package io.github.springsongs.modules.sys.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.springsongs.common.dto.ReponseResultPageDTO;
import io.github.springsongs.common.dto.ResponseDTO;
import io.github.springsongs.common.web.BaseController;
import io.github.springsongs.enumeration.ResultCode;
import io.github.springsongs.modules.sys.bo.SpringRoleQueryBO;
import io.github.springsongs.modules.sys.domain.SpringResourceRole;
import io.github.springsongs.modules.sys.domain.SpringUserRole;
import io.github.springsongs.modules.sys.dto.SpringRoleDTO;
import io.github.springsongs.modules.sys.service.ISpringResourceService;
import io.github.springsongs.modules.sys.service.ISpringRoleService;
import io.github.springsongs.util.IpKit;

@RestController
@RequestMapping(value = "/SpringRole")
public class SpringRoleController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(SpringRoleController.class);

	@Autowired
	private ISpringRoleService springRoleService;

	@Autowired
	private ISpringResourceService springResourceService;

	@PostMapping(value = "ListByPage")
	public ReponseResultPageDTO<SpringRoleDTO> listByPage(@RequestBody SpringRoleQueryBO springRoleQuery,
			@PageableDefault(page = 1, size = 20) Pageable pageable) {
		Page<SpringRoleDTO> lists = springRoleService.getAllRecordByPage(springRoleQuery, pageable);
		return ReponseResultPageDTO.successed(lists.getContent(), lists.getTotalElements(),
				ResultCode.SELECT_SUCCESSED);
	}

	@PostMapping(value = "ListByUserId/{userId}")
	public ReponseResultPageDTO<SpringRoleDTO> listByUserId(
			@PathVariable(value = "userId", required = true) String userId,
			@PageableDefault(page = 1, size = 20) Pageable pageable) {
		Page<SpringRoleDTO> lists = springRoleService.ListRoleByUserId(userId, pageable);
		return ReponseResultPageDTO.successed(lists.getContent(), lists.getTotalElements(),
				ResultCode.SELECT_SUCCESSED);
	}

	@PostMapping(value = "/Detail")
	public ResponseDTO<SpringRoleDTO> get(@NotEmpty(message = "id不能为空") String id) {
		SpringRoleDTO entity = springRoleService.selectByPrimaryKey(id);
		return ResponseDTO.successed(entity, ResultCode.SELECT_SUCCESSED);
	}

	@PostMapping(value = "/Create")
	public ResponseDTO<String> save(@RequestBody @Valid SpringRoleDTO viewEntity, HttpServletRequest request) {
		viewEntity.setCreatedBy(this.getUser().getUserName());
		viewEntity.setCreatedUserId(this.getUser().getId());
		viewEntity.setCreatedIp(IpKit.getRealIp(request));
		viewEntity.setCreatedOn(new Date());
		springRoleService.insert(viewEntity);
		return ResponseDTO.successed(null, ResultCode.SAVE_SUCCESSED);
	}

	@PostMapping(value = "/Edit")
	public ResponseDTO<String> update(@RequestBody @Valid SpringRoleDTO viewEntity, HttpServletRequest request) {
		viewEntity.setUpdatedOn(new Date());
		viewEntity.setUpdatedUserId(this.getUser().getId());
		viewEntity.setUpdatedBy(this.getUser().getUserName());
		viewEntity.setUpdatedIp(IpKit.getRealIp(request));
		springRoleService.updateByPrimaryKey(viewEntity);
		return ResponseDTO.successed(null, ResultCode.SAVE_SUCCESSED);
	}

	@PostMapping(value = "/SetDeleted")
	public ResponseDTO<String> setDeleted(@RequestParam(value = "ids", required = true) List<String> ids) {
		springRoleService.setDeleted(ids);
		return ResponseDTO.successed(null, ResultCode.DELETE_SUCCESSED);
	}

	@PostMapping(value = "/Deleted")
	public ResponseDTO<String> deleted(@RequestParam(value = "ids", required = true) List<String> ids) {
		springRoleService.setDeleted(ids);
		return ResponseDTO.successed(null, ResultCode.DELETE_SUCCESSED);
	}

	@PostMapping(value = "/SetUsers/{roleId}")
	public ResponseDTO<String> setUsers(@PathVariable(value = "roleId", required = true) String roleId,
			@RequestParam(value = "ids", required = true) List<String> userIds, HttpServletRequest request) {
		List<SpringUserRole> baseUserRoleEntityList = new ArrayList<SpringUserRole>();
		for (String str : userIds) {
			SpringUserRole entity = new SpringUserRole();
			entity.setRoleId(roleId);
			entity.setUserId(str);
			entity.setCreatedBy(this.getUser().getUserName());
			entity.setCreatedUserId(this.getUser().getId());
			entity.setCreatedIp(IpKit.getRealIp(request));
			entity.setCreatedOn(new Date());
			baseUserRoleEntityList.add(entity);
		}
		springRoleService.saveUserToRole(baseUserRoleEntityList, roleId);
		return ResponseDTO.successed(null, ResultCode.SAVE_SUCCESSED);
	}

	@PostMapping(value = "/SetAuthority/{roleId}")
	public ResponseDTO<String> setAuthority(@PathVariable(value = "roleId", required = true) String roleId,
			@RequestParam(value = "moduleIds", required = true) List<String> moduleIds, HttpServletRequest request) {
		List<SpringResourceRole> baseModuleRoleEntityList = new ArrayList<SpringResourceRole>();
		for (String str : moduleIds) {
			SpringResourceRole entity = new SpringResourceRole();
			entity.setRoleId(roleId);
			entity.setModuleId(str);
			entity.setCreatedBy(this.getUser().getUserName());
			entity.setCreatedUserId(this.getUser().getId());
			entity.setCreatedIp(IpKit.getRealIp(request));
			entity.setCreatedOn(new Date());
			baseModuleRoleEntityList.add(entity);
		}
		springResourceService.saveModuleToRole(baseModuleRoleEntityList, roleId);
		return ResponseDTO.successed(null, ResultCode.SAVE_SUCCESSED);
	}

	@PostMapping(value = "/ListAuthority/{roleId}")
	public ResponseDTO<List<String>> listAuthority(@PathVariable(value = "roleId", required = true) String roleId) {

		List<SpringResourceRole> baseModuleRoleEntityList = springResourceService.listModulesByRoleId(roleId);
		List<String> moduleIds = new ArrayList<String>();
		baseModuleRoleEntityList.stream().forEach(item -> {
			moduleIds.add(item.getModuleId());
		});
		return ResponseDTO.successed(moduleIds, ResultCode.SELECT_SUCCESSED);
	}
}