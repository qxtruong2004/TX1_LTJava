package KtraTX1;

import java.util.List;

public interface ComputerManager {
    public boolean addComputer(Computer c);
    public boolean editComputer(Computer c);
    public boolean delComputer(Computer c);
    public List<Computer> searchComputers(String name);
    public List<Computer> sortedComputer( double price);
}
