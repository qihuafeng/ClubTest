package com.clubTest.controller.admin;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.clubTest.entity.Team;
import com.clubTest.service.TeamService;
import com.clubTest.util.DateUtil;

@RestController
@RequestMapping("/admin/team")
public class TeamAdminController {
	
	@Resource
	private TeamService teamService;
	
	@Value("${imageFilePath}")
	private String imageFilePath;
	
	
	@RequestMapping("/ckeditorUpload")
	public String ckeditorUpload(@RequestParam("upload")MultipartFile file,String CKEditorFuncNum)throws Exception{
		String fileName=file.getOriginalFilename(); // 获取文件名
		String suffixName=fileName.substring(fileName.lastIndexOf(".")); // 获取文件的后缀
		String newFileName=DateUtil.getCurrentDateStr()+suffixName;
		FileUtils.copyInputStreamToFile(file.getInputStream(), new File(imageFilePath+newFileName));
		
		StringBuffer sb=new StringBuffer();
	    sb.append("<script type=\"text/javascript\">");
	    sb.append("window.parent.CKEDITOR.tools.callFunction("+ CKEditorFuncNum + ",'" +"/static/newsImage/"+ newFileName + "','')");
	    sb.append("</script>");
	     
	    return sb.toString();
		
	}
	/**
	 * 分页查询成员信息
	 * @param page
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public Map<String,Object> list(@RequestParam(value="page",required=false)Integer page,@RequestParam(value="rows",required=false)Integer rows)throws Exception{
		List<Team> teamList=teamService.list(page-1, rows);
		Long total=teamService.getCount();
		Map<String,Object> resultMap=new HashMap<String,Object>();
		resultMap.put("rows",teamList);
		resultMap.put("total", total);
		return resultMap;
	}
	
	/**
	 * 添加或者修改成员信息
	 * @param link
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public Map<String,Object> save(Team team)throws Exception{
		Map<String,Object> resultMap=new HashMap<String,Object>();
		teamService.save(team);	
		resultMap.put("success", true);
		return resultMap;
	}
	
	/**
	 * 删除友情链接
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public Map<String,Object> delete(@RequestParam(value="ids")String ids)throws Exception{
		String []idsStr=ids.split(",");
		Map<String,Object> resultMap=new HashMap<String,Object>();
		for(int i=0;i<idsStr.length;i++){
			teamService.delete(Integer.parseInt(idsStr[i]));
		}
		
		resultMap.put("success", true);
		return resultMap;
	}
}
