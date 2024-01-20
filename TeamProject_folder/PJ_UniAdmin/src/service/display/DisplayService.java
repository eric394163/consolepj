package service.display;

import model.ManageUni;

public interface DisplayService {
    public void Display(ManageUni manageUni, int selectModel, Runnable... methods);

}
