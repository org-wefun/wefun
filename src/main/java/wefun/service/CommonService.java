package wefun.service;

import wefun.model.vo.AccessReq;
import wefun.model.vo.AccessRsp;

public interface CommonService {
	AccessRsp getAccess(AccessReq accessReq);
}
