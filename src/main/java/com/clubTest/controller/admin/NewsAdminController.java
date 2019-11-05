package com.clubTest.controller.admin;

import java.io.File;
import java.util.Date;
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

import com.clubTest.entity.News;
import com.clubTest.service.NewsService;
import com.clubTest.util.DateUtil;

@RestController
@RequestMapping("/admin/news")
public class NewsAdminController {
	
	
	@Resource
	private NewsService newsService;
	
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
	 * 添加或者修改电影信息
	 * @param film
	 * @param file
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public Map<String,Object> save(News news,@RequestParam("imageFile")MultipartFile file)throws Exception{  
		if(!file.isEmpty()){
			String fileName=file.getOriginalFilename(); // 获取文件名
			String suffixName=fileName.substring(fileName.lastIndexOf(".")); // 获取文件的后缀
			String newFileName=DateUtil.getCurrentDateStr()+suffixName;
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(imageFilePath+newFileName));
			news.setImageName(newFileName);
		}
		news.setPublishDate(new Date());
		Map<String,Object> resultMap=new HashMap<String,Object>();
		newsService.save(news);
		resultMap.put("success", true);
		return resultMap;
	}
	
	/**
	 * 分页查询新闻信息
	 * @param page
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public Map<String,Object> list(News news,@RequestParam(value="page",required=false)Integer page,@RequestParam(value="rows",required=false)Integer rows)throws Exception{
		List<News> newsList=newsService.list(news,page-1, rows);
		Long total=newsService.getCount(news);
		Map<String,Object> resultMap=new HashMap<String,Object>();
		resultMap.put("rows", newsList);
		resultMap.put("total", total);
		return resultMap;
	}
	
	/**
	 * 删除新闻信息
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public Map<String,Object> delete(@RequestParam(value="ids")String ids)throws Exception{
		String []idsStr=ids.split(",");
		Map<String,Object> resultMap=new HashMap<String,Object>();
		for(int i=0;i<idsStr.length;i++) {
			newsService.delete(Integer.parseInt(idsStr[i]));							
		}	
		resultMap.put("success", true);		
		return resultMap;
	}
	
	/**
	 * 根据id查找实体
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findById")
	public News findById(Integer id)throws Exception{
		return newsService.findById(id);
	}
	
}
