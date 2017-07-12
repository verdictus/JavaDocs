package ro.teamnet.zth.appl.domain;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

import java.util.Date;

/**
 * Created by madalin.mocanu on 7/12/2017.
 */
@Table(name = "Employee")
public class Employee {
    @Id(name = "job_id")
    private Long id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (commissionPct != employee.commissionPct) return false;
        if (id != null ? !id.equals(employee.id) : employee.id != null) return false;
        if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
        if (lastName != null ? !lastName.equals(employee.lastName) : employee.lastName != null) return false;
        if (email != null ? !email.equals(employee.email) : employee.email != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(employee.phoneNumber) : employee.phoneNumber != null)
            return false;
        if (hireDate != null ? !hireDate.equals(employee.hireDate) : employee.hireDate != null) return false;
        if (idjob != null ? !idjob.equals(employee.idjob) : employee.idjob != null) return false;
        if (salary != null ? !salary.equals(employee.salary) : employee.salary != null) return false;
        if (idmanager != null ? !idmanager.equals(employee.idmanager) : employee.idmanager != null) return false;
        return iddepartment != null ? iddepartment.equals(employee.iddepartment) : employee.iddepartment == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (hireDate != null ? hireDate.hashCode() : 0);
        result = 31 * result + (idjob != null ? idjob.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        result = 31 * result + (int) (commissionPct ^ (commissionPct >>> 32));
        result = 31 * result + (idmanager != null ? idmanager.hashCode() : 0);
        result = 31 * result + (iddepartment != null ? iddepartment.hashCode() : 0);
        return result;
    }

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", hireDate=" + hireDate +
                ", idjob=" + idjob +
                ", salary=" + salary +
                ", commissionPct=" + commissionPct +
                ", idmanager=" + idmanager +
                ", iddepartment=" + iddepartment +
                '}';
    }

    @Column(name = "phone_number")
    private Long phoneNumber;
    @Column(name = "hire_date")
    private Date hireDate;
    @Id(name = "job_id")
    private Job idjob;
    @Column(name = "salary")
    private Long salary;
    @Column(name = "commission_pct")
    private long commissionPct;
    @Id(name = "manager_id")
    private Employee idmanager;
    @Column(name = "department_id")
    private Department iddepartment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Job getIdjob() {
        return idjob;
    }

    public void setIdjob(Job idjob) {
        this.idjob = idjob;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public long getCommissionPct() {
        return commissionPct;
    }

    public void setCommissionPct(long commissionPct) {
        this.commissionPct = commissionPct;
    }

    public Employee getIdmanager() {
        return idmanager;
    }

    public void setIdmanager(Employee idmanager) {
        this.idmanager = idmanager;
    }

    public Department getIddepartment() {
        return iddepartment;
    }

    public void setIddepartment(Department iddepartment) {
        this.iddepartment = iddepartment;
    }
}
