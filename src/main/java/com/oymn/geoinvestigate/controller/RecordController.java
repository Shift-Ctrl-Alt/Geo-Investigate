package com.oymn.geoinvestigate.controller;

import com.oymn.geoinvestigate.common.annotation.CheckUser;
import com.oymn.geoinvestigate.common.annotation.CheckUserForAddRecord;
import com.oymn.geoinvestigate.dao.exception.ConditionException;
import com.oymn.geoinvestigate.dao.pojo.*;
import com.oymn.geoinvestigate.handler.UserSupport;
import com.oymn.geoinvestigate.service.FileService;
import com.oymn.geoinvestigate.service.RecordService;
import com.oymn.geoinvestigate.vo.RecordVo;
import com.oymn.geoinvestigate.vo.Result;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.applet.Main;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

/**
 * 记录的相关接口
 */
@Api("记录的相关接口")
@RestController
public class RecordController {

    @Autowired
    private FileService fileService;

    @Autowired
    private RecordService recordService;

    @Autowired
    private UserSupport userSupport;

    /**
     * 添加图片
     *
     * @param uploadImg 上传的图片
     * @param request   请求
     * @return 该图片的访问地址
     */
    @ApiOperation("上传图片的方法")
    @PostMapping("img")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uploadImg", paramType="form", value = "uploadImg", dataType="file", required = true),
            @ApiImplicitParam(name="dir", value="dir", dataTypeClass = String.class, required = true)
    })
    public Result uploadFile(@RequestPart("file") @RequestParam(value = "file", required = true) MultipartFile uploadImg,
                             String dir,
                             HttpServletRequest request) {
        String imgPath = fileService.uploadFile(uploadImg, dir, request);
        return Result.success(imgPath);
    }

    /**
     * 添加一条空的主记录
     *
     * @return
     */
    @ApiOperation("添加一条空记录")
    @PostMapping("invest-record")
    public Result<Long> addMainRecord() {
        Long userId = userSupport.getCurrentUserId();
        Record record = new Record();
        record.setUserId(userId);
        Long id = recordService.addMainRecord(record);
        return Result.success(id);
    }

    /**
     * 修改主记录
     *
     * @param record
     * @return
     */
    @ApiOperation("修改主记录")
    @PutMapping("invest-record")
    @CheckUser
    public Result updateMainRecord(@ApiParam("记录类") @RequestBody Record record) {
        recordService.updateMainRecord(record);
        return Result.success();
    }

    /**
     * 添加一条空的病害样本采集表记录
     *
     * @return
     */
    @ApiOperation("添加一条空的病害样本采集表记录")
    @PostMapping("disease-sam-coll-record")
    @CheckUserForAddRecord
    public Result<Long> addDiseaseSamCollRecord(@ApiParam("主记录的id") @RequestParam Long mainRecordId) {
        DiseaseSamCollRecord diseaseSamCollRecord = new DiseaseSamCollRecord();
        diseaseSamCollRecord.setRecordId(mainRecordId);
        Long id = recordService.addDiseaseSamCollRecord(diseaseSamCollRecord);
        return Result.success(id);
    }

    /**
     * 更新病害样本采集表记录
     *
     * @param diseaseSamCollRecord
     * @return
     */
    @ApiOperation("更新病害样本采集表记录")
    @PutMapping("disease-sam-coll-record")
    @CheckUser
    public Result updateDiseaseSamCollRecord(@ApiParam("病害样本采集表的实体类") @RequestBody DiseaseSamCollRecord diseaseSamCollRecord) {
        recordService.updateDiseaseSamCollRecord(diseaseSamCollRecord);
        return Result.success();
    }

    @ApiOperation("添加一条空的病害系统调查表记录")
    @PostMapping("disease-sys-survey-record")
    @CheckUserForAddRecord
    public Result<Long> addDiseaseSysSurveyRecord(@ApiParam("主记录的id") @RequestParam Long mainRecordId) {
        DiseaseSysSurveyRecord diseaseSysSurveyRecord = new DiseaseSysSurveyRecord();
        diseaseSysSurveyRecord.setRecordId(mainRecordId);
        Long id = recordService.addDiseaseSysSurveyRecord(diseaseSysSurveyRecord);
        return Result.success(id);
    }

    @ApiOperation("更新病害系统调查表记录")
    @PutMapping("disease-sys-survey-record")
    @CheckUser
    public Result updateDiseaseSysSurveyRecord(@ApiParam("病害系统调查表的实体类") @RequestBody DiseaseSysSurveyRecord diseaseSysSurveyRecord) {
        recordService.updateDiseaseSysSurveyRecord(diseaseSysSurveyRecord);
        return Result.success();
    }

    @ApiOperation("添加一条空的机-地病害数据采集表记录")
    @PostMapping("disease-data-coll-uav-record")
    @CheckUserForAddRecord
    public Result<Long> addDiseaseDataCollUAVRecord(@ApiParam("主记录的id") @RequestParam Long mainRecordId) {
        DiseaseDataCollUAVRecord diseaseDataCollUAVRecord = new DiseaseDataCollUAVRecord();
        diseaseDataCollUAVRecord.setRecordId(mainRecordId);
        Long id = recordService.addDiseaseDataCollUAVRecord(diseaseDataCollUAVRecord);
        return Result.success(id);
    }

    @ApiOperation("更新机-地病害数据采集表记录")
    @PutMapping("disease-data-coll-uav-record")
    @CheckUser
    public Result updateDiseaseDataCollUAVRecord(@ApiParam("机-地病害数据采集表的实体类") @RequestBody DiseaseDataCollUAVRecord diseaseDataCollUAVRecord) {
        recordService.updateDiseaseDataCollUAVRecord(diseaseDataCollUAVRecord);
        return Result.success();
    }

    // TODO: 这里得想好表和图片的关系
    @ApiOperation("添加一条空的虫害采集表")
    @PostMapping("pest-coll-record")
    @CheckUserForAddRecord
    public Result<Long> addPestCollRecord(@ApiParam("主记录的id") @RequestParam Long mainRecordId) {
        PestCollRecord pestCollRecord = new PestCollRecord();
        pestCollRecord.setRecordId(mainRecordId);
        Long id = recordService.addPestCollRecord(pestCollRecord);
        return Result.success(id);
    }

    /**
     * 添加虫害采集表中的虫害叶片照片，虫害叶片照片只有添加和删除，没有更新一说
     *
     * @param pestImgRecord
     * @return
     */
    @ApiOperation("添加虫害叶片照片")
    @PostMapping("pest-img-record")
    public Result<Long> addPestImgRecord(@ApiParam("虫害叶片照片实体类") @RequestBody PestImgRecord pestImgRecord) {
        Long id = recordService.addPestImgRecord(pestImgRecord);
        return Result.success(id);
    }

    @ApiOperation("删除虫害叶片照片")
    @DeleteMapping("pest-img-record")
    // TODO: 可以尝试将删除这段用户判断也弄成一个注解
    public Result deletePestImgRecord(@ApiParam("虫害叶片照片记录的id") @RequestParam Long pestImgRecordId) {
        Long currentUserId = userSupport.getCurrentUserId();
        Long userId = recordService.getUserIdByPestImgRecordId(pestImgRecordId);
        if (currentUserId != userId) {
            throw new ConditionException("该记录所有者不是当前登录用户");
        }

        recordService.deletePestImgRecordById(pestImgRecordId);

        return Result.success();
    }

    @ApiOperation("更新虫害采集表记录")
    @PutMapping("pest-coll-record")
    @CheckUser
    public Result updatePestCollRecord(@ApiParam("虫害采集表记录的实体") @RequestBody PestCollRecord pestCollRecord) {
        recordService.updatePestCollRecord(pestCollRecord);
        return Result.success();
    }

    @ApiOperation("添加一条空的机-地虫害调查表记录")
    @PostMapping("pest-survey-uav-record")
    @CheckUserForAddRecord
    public Result<Long> addPestSurveyUAVRecord(@ApiParam("主记录的id") @RequestParam Long mainRecordId) {
        PestSurveyUAVRecord pestSurveyUAVRecord = new PestSurveyUAVRecord();
        pestSurveyUAVRecord.setRecordId(mainRecordId);
        Long id = recordService.addPestSurveyUAVRecord(pestSurveyUAVRecord);
        return Result.success(id);
    }

    @ApiOperation("更新机-地虫害调查表记录")
    @PutMapping("pest-survey-uav-record")
    @CheckUser
    public Result updatePestSurveyUAVRecord(@ApiParam("机-地虫害调查表记录的实体") @RequestBody PestSurveyUAVRecord pestSurveyUAVRecord) {
        recordService.updatePestSurveyUAVRecord(pestSurveyUAVRecord);
        return Result.success();
    }

    @ApiOperation("添加机-地虫害叶片照片表记录")
    @PostMapping("pest-uav-img-record")
    public Result<Long> addPestUAVImgRecord(@ApiParam("机-地虫害叶片照片表实体类") @RequestBody PestUAVImgRecord pestUAVImgRecord) {
        Long id = recordService.addPestUAVImgRecord(pestUAVImgRecord);
        return Result.success(id);
    }

    @ApiOperation("删除机-地虫害叶片照片表记录")
    @DeleteMapping("pest-uav-img-record")
    public Result deletePestUAVImgRecord(@ApiParam("机-地虫害叶片照片表记录的id") @RequestParam Long pestUAVImgRecordId) {
        Long currentUserId = userSupport.getCurrentUserId();
        Long userId = recordService.getUserIdByPestUAVImgRecordId(pestUAVImgRecordId);
        if (currentUserId != userId) {
            throw new ConditionException("该记录所有者不是当前登录用户");
        }
        recordService.deletePestUAVImgRecordById(pestUAVImgRecordId);
        return Result.success();
    }

    @ApiOperation("添加一条空的环境要素")
    @PostMapping("environment-factor")
    @CheckUserForAddRecord
    public Result addEnvironmentFactor(@ApiParam("主记录的id") @RequestParam Long mainRecordId) {
        EnvironmentFactorRecord environmentFactorRecord = new EnvironmentFactorRecord();
        environmentFactorRecord.setRecordId(mainRecordId);
        Long id = recordService.addEnvironmentFactor(environmentFactorRecord);
        return Result.success(id);
    }
    
    @ApiOperation("更新环境要素")
    @PutMapping("environment-factor")
    @CheckUser
    public Result updateEnvironmentFactor(@ApiParam("环境要素的实体类") @RequestBody EnvironmentFactorRecord environmentFactorRecord){
        recordService.updateEnvironmentFactor(environmentFactorRecord);
        return Result.success();
    }
    

    /**
     * 查询记录
     *
     * @param pageSize
     * @param pageNo
     * @return
     */
    @ApiOperation("分页查询记录")
    @GetMapping("page-record")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageSize", value = "每页多少条记录", required = true),
            @ApiImplicitParam(name = "pageNo", value = "第几页", required = true)
    })
    public Result<PageResult<Record>> pageRecords(@RequestParam Integer pageSize,
                                                 @RequestParam Integer pageNo) {
        Long userId = userSupport.getCurrentUserId();
        PageResult<Record> recordList = recordService.getRecords(userId, pageNo, pageSize);

        return Result.success(recordList);

    }


    /**
     * 删除记录
     *
     * @param recordId
     * @return
     */
    @ApiOperation("删除记录")
    @DeleteMapping("invest-record")
    public Result deleteRecord(@ApiParam("记录id") @RequestParam Long recordId) {
        Long currentUserId = userSupport.getCurrentUserId();
        recordService.deleteRecord(currentUserId, recordId);
        return Result.success();
    }
    
    @ApiOperation("根据id查询记录")
    @GetMapping("invest-record")
    public Result<RecordVo> getRecord(@ApiParam("记录的id") @RequestParam Long recordId){
        RecordVo recordVo = recordService.getRecordVoById(recordId);
        return Result.success(recordVo);
    }
}
