package by.it.academy.clinic.dao.impl;

import by.it.academy.clinic.dao.BaseDao;
import by.it.academy.clinic.dao.EmployeeDetailDao;
import by.it.academy.clinic.entity.EmployeeDetail;

public class EmployeeDetailDaoImpl extends BaseDao<EmployeeDetail> implements EmployeeDetailDao {
    EmployeeDetailDaoImpl(){
        super(EmployeeDetail.class);
    }

}
