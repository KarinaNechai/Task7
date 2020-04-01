package com.task8.service;

import com.task8.model.Check;
import com.task8.model.TypeOfCheck;

import java.util.Date;
import java.util.List;

public interface ICheckService  {
    public Check insertCheck(Check check);
    public boolean updateCheck(Check check);
    public boolean deleteCheck(int checkN);
    public float totalByTypeOfCheck(List<Check> checkList,TypeOfCheck type);
    public List<Check> getChecks(String userLogin);
    public List<Check> getChecksByPeriod(Date dateStart, Date dateEnd, String userLogin);
    public List<Check> getChecksByPeriod(Date dateStart, Date dateEnd, TypeOfCheck type, String userLogin);
}
