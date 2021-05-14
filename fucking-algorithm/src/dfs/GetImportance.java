package dfs;

import java.util.List;

/**
 * 690. 员工的重要性
 * @author 路飞
 * @create 2021/5/1 8:36
 */
public class GetImportance {
    public static void main(String[] args) {

    }
    private static int res = 0;
    public static int getImportance(List<Employee> employees, int id) {
        for (Employee e : employees) {
            if (e.id == id) {
                res += e.importance;
                for (int i : e.subordinates) {
                    getImportance(employees, i);
                }
            }
        }
        return res;
    }
}
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public List<Integer> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<Integer> subordinates) {
        this.subordinates = subordinates;
    }
}
