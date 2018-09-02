package com.yuanbao.park.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import com.yuanbao.park.common.req.StatisticsReqParam;
import com.yuanbao.park.common.resp.CommonRespParam;
import com.yuanbao.park.common.respPojo.StatisticsInfoData;
import com.yuanbao.park.common.resultUtils.Message;
import com.yuanbao.park.common.utils.MyCollectionsUtils;
import com.yuanbao.park.dao.master.*;
import com.yuanbao.park.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import com.yuanbao.park.service.StatisticsService;

import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;
/**
 * @Author: xiankang
 * @Date: 2018/7/4 17:15
 * @Description:园区统计持久化层
 * @Problem:
 * @Return:
 */
@Service
public class StatisticsServiceImpl implements StatisticsService {
    private static Logger logger = LoggerFactory.getLogger(StatisticsServiceImpl.class);
	@Autowired
	private StatisticsMapper statisticsMapper;

	@Autowired
    private CompanyMapper companyMapper;

	@Autowired
    private CompanyOperateInfoMapper companyOperateInfoMapper;

	@Autowired
    private CompanyPatentMapper companyPatentMapper;

	@Autowired
    private CompanyTalentStatMapper companyTalentStatMapper;

	/**
	 * @Author: xiankang
	 * @Date: 2018/7/4 17:17
	 * @Description:园区统计查询
	 * @Problem:
	 * @Return:
	 */
	@Override
	public CommonRespParam getstatisticsByParkIdAndYear(StatisticsReqParam statisticsReqParam) {
       //先查询出所有字段，后储存至园区统计表中
        //查询企业数量
        Statistics statistics=new Statistics();
        //1.将园区id,和年份信息存入实体类中
        BeanUtils.copyProperties(statisticsReqParam,statistics);
        Example companyExample=new Example(Company.class);
        Example.Criteria criteria = companyExample.createCriteria();
        criteria.andEqualTo("deleteType",0);
        criteria.andEqualTo("entryTime",statisticsReqParam.getYear());
        //具体年企业数量（包含所有入住状态）
        int isOk=companyMapper.selectCountByExample(companyExample);
        //2.将企业数量持久化到实体类
        statistics.setCompanyNum((long) isOk);
        //入孵企业数量
        criteria.andEqualTo("entryState",2);
        int isOk2=companyMapper.selectCountByExample(companyExample);
        //3.将在孵企业家数量持久化到实体类
        statistics.setCompanyNum((long) isOk2);
        //4.大学生企业家
        Example collegeCompanyExample=new Example(Company.class);
        Example.Criteria collegeCriteria = collegeCompanyExample.createCriteria();
        collegeCriteria.andEqualTo("category",5).andEqualTo("deleteType",0);
        int collegeNum=companyMapper.selectCountByExample(companyExample);
        statistics.setCollege((long)collegeNum);
        //16.高新技术企业家
        Example highTechnologyCompanyExample=new Example(Company.class);
        Example.Criteria highTechnologyCompanyCriteria = highTechnologyCompanyExample.createCriteria();
        highTechnologyCompanyCriteria.andEqualTo("qualifications",1).andEqualTo("deleteType",0);
        int highTechnologyCompany=companyMapper.selectCountByExample(companyExample);
        statistics.setCollege((long)highTechnologyCompany);
        //17.瞪羚企业（家）
        Example GazelleCompanyExample=new Example(Company.class);
        Example.Criteria GazelleCompanyCriteria2 = GazelleCompanyExample.createCriteria();
        GazelleCompanyCriteria2.andEqualTo("qualifications",2).andEqualTo("deleteType",0);
        int GazelleCompany=companyMapper.selectCountByExample(companyExample);
        statistics.setCollege((long)GazelleCompany);

        //具体年总收入,上交税收与及其开发项目
        Example moneyExample=new Example(Company.class);
        Example.Criteria moneyCriteria = companyExample.createCriteria();
        moneyCriteria.andEqualTo("deleteType",0);
        moneyCriteria.andEqualTo("years",statisticsReqParam.getYear());
        CompanyOperateInfo companyOperateInfo=companyOperateInfoMapper.selectOneByExample(moneyExample);
        BigDecimal totalRevenueBig=new BigDecimal(companyOperateInfo.getYearlyIncoming());
        BigDecimal taxBig=new BigDecimal(companyOperateInfo.getTaxPayed());
        BigDecimal yearlyRDFundBig=new BigDecimal(companyOperateInfo.getYearlyRDFund());
        BigDecimal nationalRDFinancingBig=new BigDecimal(companyOperateInfo.getNationalRDFinancing());
        BigDecimal provinceRDFinancingBig=new BigDecimal(companyOperateInfo.getProvinceRDFinancing());
        BigDecimal yi=new BigDecimal(100000000);
        //5.总收入
        Double totalRevenue = (totalRevenueBig.divide(yi, 4, RoundingMode.HALF_UP)).doubleValue();
        statistics.setTotalRevenue(totalRevenue);
        //6.上交税收
        Double tax= (taxBig.divide(yi, 4, RoundingMode.HALF_UP)).doubleValue();
        statistics.setTax(tax);
        //7.年度研究经费
        Double yearlyRDFund= (yearlyRDFundBig.divide(yi, 4, RoundingMode.HALF_UP)).doubleValue();
        statistics.setInvestigativeRate(yearlyRDFund);
        //8.承担国家科研项目数目
        Integer nationalRDProject = companyOperateInfo.getNationalRDProject();
        statistics.setNationalProject(nationalRDProject);
        //9.承担国家科研和产业化获得资助 （亿元）
        Double nationalRDFinancing= (nationalRDFinancingBig.divide(yi, 4, RoundingMode.HALF_UP)).doubleValue();
        statistics.setNationalProjectFunding(nationalRDFinancing);
        //10.承担省市区科研开发项目
        Integer provinceRDProject = companyOperateInfo.getProvinceRDProject();
        statistics.setProvincialProject(provinceRDProject);
        //11.承担省市区科研开发项目获得资助金额（亿元）
        Double provinceRDFinancing = (provinceRDFinancingBig.divide(yi, 4, RoundingMode.HALF_UP)).doubleValue();
        statistics.setProvincialProjectFunding(provinceRDFinancing);
        //自主知识产权(项）产权的检索
        Example patentExample=new Example(Company.class);
        Example.Criteria patentCriteria = companyExample.createCriteria();
        patentCriteria.andEqualTo("deleteType",0);
        patentCriteria.andEqualTo("years",statisticsReqParam.getYear());
        List<CompanyPatent> companyPatents = companyPatentMapper.selectByExample(patentExample);
        CompanyPatent companyPatent=new CompanyPatent();
        BeanUtils.copyProperties(companyPatents.get(0),companyPatent);
        //12.知识产权
        statistics.setIntellectualProperty(companyPatent.getProprietary());
        //13.获批软件著作权
        statistics.setSoftwareCopyright(companyPatent.getSoftware());
        //14.发明专利
        statistics.setInventionPatent(companyPatent.getInvention());
        //15.获批专利
        statistics.setPatent(companyPatent.getCopyright());
        //companyTalentStat
        //18.千人计划
        Example companyEeample=new Example(CompanyTalentStat.class);














        CommonRespParam commonRespParam=new CommonRespParam();
		//拼接查询条件

        try {
            Example statisticsExample = new Example(Statistics.class);
            Example.Criteria statisticsExampleCriteria = statisticsExample.createCriteria();
            statisticsExampleCriteria.andEqualTo("parkId",statisticsReqParam.getParkId());
            statisticsExampleCriteria.andEqualTo("years",statisticsReqParam.getYear());
            statisticsExampleCriteria.andEqualTo("deleteType",0);
            List<Statistics> statisticsList = statisticsMapper.selectByExample(statisticsExample);
            if (MyCollectionsUtils.isNotEmpty(statisticsList)){
                Statistics statistic =statisticsList.get(0);
                StatisticsInfoData statisticsInfoData=new StatisticsInfoData();
                BeanUtils.copyProperties(statistic,statisticsInfoData);
                commonRespParam.setDataInfo(statisticsInfoData);
                return commonRespParam;
            }else{
                commonRespParam.setResultCode(Message.FAILURE_CODE);
                commonRespParam.setResultMsg(Message.FAILURE);
                return commonRespParam;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            commonRespParam.setResultCode(Message.FAILURE_CODE);
            commonRespParam.setResultMsg(Message.FAILURE );
            return commonRespParam;
        }

    }


}
