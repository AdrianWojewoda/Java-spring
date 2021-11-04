package pjatk.adrwoj.jazs16095nbp.Model;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class NBP {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private EnumGold Gold;
    @Column(name = "start_date")
    private LocalDate start;
    @Column(name = "end_ate")
    private LocalDate end;
    @Column(name = "average")
    private Double avg;
    @Column(name = "save_time")
    private Date save;


    public NBP(EnumGold gold, LocalDate start, LocalDate end, Double avg, Date save) {
        Gold = gold;
        this.start = start;
        this.end = end;
        this.avg = avg;
        this.save = save;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EnumGold getGold() {
        return Gold;
    }

    public void setGold(EnumGold gold) {
        Gold = gold;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public Double getAvg() {
        return avg;
    }

    public void setAvg(Double avg) {
        this.avg = avg;
    }

    public Date getSave() {
        return save;
    }

    public void setSave(Date save) {
        this.save = save;
    }
}
