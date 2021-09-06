package database;

import domain_classes.Driver;
import domain_classes.Squad;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class ImplementResult {
    ArrayList<Driver> race;
    ArrayList<Driver> qf;
    RestResult rr = new RestResult();

    public void afterQualifying(List<Driver> qf) {
        int tot = 0;
        int pos = 21;
        for (Driver i : qf) {
            if (!i.getQualifying_position().equals("R"))
                pos = parseInt(i.getQualifying_position());
            if (pos != 0)
                tot += 1;
            else
                pos = 21;
            if (pos <= 15)
                tot += 2;
            if (pos <= 10) {
                tot += 3;
                for (int j = 1; j < 11; j++)
                    if (pos == j)
                        tot += 11 - j;
            }

            if (pos < parseInt(Squad.getConstructorByDriver(i.getName(), i.getNumber()).getD2().getQualifying_position()) &&
                    i.getName().equals(Squad.getConstructorByDriver(i.getName(), i.getNumber()).getD1().getName()) && i.getNumber() == Squad.getConstructorByDriver(i.getName(), i.getNumber()).getD1().getNumber())
                i.setFantaF1points(2, false);
            if (parseInt(Squad.getConstructorByDriver(i.getName(), i.getNumber()).getD1().getQualifying_position()) > pos &&
                    i.getName().equals(Squad.getConstructorByDriver(i.getName(), i.getNumber()).getD2().getName()) && i.getNumber() == Squad.getConstructorByDriver(i.getName(), i.getNumber()).getD2().getNumber())
                i.setFantaF1points(2, false);

            i.setFantaF1points(tot, true);
            tot = 0;
        }

    }

    public void afterRace(List<Driver> race) {
        int tot = 0;
        int pos = 21;
        for (Driver i : race) {
            if (!i.getRace_position().equals("R")) {
                pos = parseInt(i.getRace_position());
                if (pos != 0)
                    tot += 1;
                else {
                    i.setFantaF1points(-15, false);
                    pos = 21;
                }
            } else
                i.setFantaF1points(-15, false);

            if (pos == 1)
                tot += 25;
            if (pos == 2)
                tot += 18;
            if (pos == 3)
                tot += 15;
            if (pos == 4)
                tot += 12;
            if (pos == 5)
                tot += 10;
            if (pos == 6)
                tot += 8;
            if (pos == 7)
                tot += 6;
            if (pos == 8)
                tot += 4;
            if (pos == 9)
                tot += 2;
            if (pos == 10)
                tot += 1;

            if (pos < parseInt(Squad.getConstructorByDriver(i.getName(), i.getNumber()).getD2().getRace_position()) &&
                    i.getName().equals(Squad.getConstructorByDriver(i.getName(), i.getNumber()).getD1().getName()) && i.getNumber() == Squad.getConstructorByDriver(i.getName(), i.getNumber()).getD1().getNumber())
                i.setFantaF1points(3, false);
            if (parseInt(Squad.getConstructorByDriver(i.getName(), i.getNumber()).getD1().getRace_position()) > pos &&
                    i.getName().equals(Squad.getConstructorByDriver(i.getName(), i.getNumber()).getD2().getName()) && i.getNumber() == Squad.getConstructorByDriver(i.getName(), i.getNumber()).getD2().getNumber())
                i.setFantaF1points(3, false);

            i.setFantaF1points(tot, true);
            tot = 0;
        }
    }

    public void comparison(List<Driver> race, List<Driver> qf) {

        int tot = 0;
        int posrace = 21, posq = 21;

        for (Driver d : race) {
            if (!d.getRace_position().equals("R"))
                posrace = parseInt(d.getRace_position());

            for (Driver dq : qf) {
                if (dq.getName().equals(d.getName()) && dq.getNumber() == d.getNumber())
                    posq = parseInt(dq.getQualifying_position());
            }

            if (posq < posrace && posq <= 10 && posrace != 21 && posrace != 0)
                tot -= Math.min((posrace - posq) * 2, 10);

            if (posq < posrace && posq > 10 && posrace != 21 && posrace != 0)
                tot -= Math.min((posrace - posq), 5);

            if (posq > posrace && posrace != 21 && posrace != 0) {
                tot += Math.min((posq - posrace) * 2, 10);
            }

            d.setFantaF1points(tot, true);
            tot = 0;
        }
    }

    public ImplementResult() {
        race = rr.getRaceResult();
        qf = rr.getQualifyingResult();
        if (race != null) {
            afterQualifying(qf);
            afterRace(race);
            comparison(race, qf);
        }
    }

}
