package wefun.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;

import wefun.commons.exception.BusinessRuntimeException;
import wefun.model.vo.AccessReq;
import wefun.model.vo.AccessRsp;
import wefun.service.CommonService;
@Service
public class CommonServiceImpl extends BaseServiceImpl implements CommonService{
	@Value("${endPoint}")
	private String endpoint;
	@Value("${accessKeyId}")
	private String accessId;
	@Value("${accessKeySecret}")
	private String accessKey;
	@Value("${bucket}")
	private String bucket;
	@Override
	public AccessRsp getAccess(AccessReq accessReq) {
		if (null == accessReq) {
			throw new BusinessRuntimeException("parameter can't be null");
		}
		final String dir = accessReq.getDir();
		OSSClient client    = new OSSClient(endpoint, accessId, accessKey);
		AccessRsp accessRsp = new AccessRsp();
		try {
			final long expirySeconds = 60 * 2;
			final long expiryTime    = System.currentTimeMillis() + expirySeconds * 1000;
			Date expiration = new Date(expiryTime);
			PolicyConditions policyConds = new PolicyConditions();
			policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
			policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);
			String postPolicy = client.generatePostPolicy(expiration, policyConds);
			byte[] binaryData = postPolicy.getBytes("utf-8");
			String encodedPolicy = BinaryUtil.toBase64String(binaryData);
			String postSignature = client.calculatePostSignature(postPolicy);
			accessRsp.setAccessid(accessId);
			accessRsp.setDir(dir);
			accessRsp.setExpire(expiryTime / 1000);
			accessRsp.setHost("http://" + bucket + "." + endpoint);
			accessRsp.setPolicy(encodedPolicy);
			accessRsp.setSignature(postSignature);
		} catch (Exception e) {
			LOG.info(e.getMessage(), e);
		}
		return accessRsp;
	}

}
