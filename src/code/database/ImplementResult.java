package database;

import domain_classes.Driver;
import domain_classes.Squad;
import java.util.List;

import static java.lang.Integer.parseInt;

public class ImplementResult implements Runnable{
    List<Driver> race;
    List<Driver> qf;
    RestResult rr = new RestResult();

    public void afterQualifying(List<Driver> qf) {
        int tot = 0;
        int pos = 21;
        for (Driver i : qf) {
            if (!i.getQualifying_position().equals("R"))
                pos = parseInt(i.getQualifying_position());
            tot += 1;
            if (pos <= 15)
                tot += 2;
            if (pos <= 10) {
                tot += 3;
                for (int j = 1; j < 11; j++)
                    if (pos == j)
                        tot += 11 - j;
            }

            if (parseInt(Squad.getConstructorByDriver(i.getName(), i.getNumber()).getD1().getQualifying_position()) < parseInt(Squad.getConstructorByDriver(i.getName(), i.getNumber()).getD2().getQualifying_position()) &&
                    i.getName().equals(Squad.getConstructorByDriver(i.getName(), i.getNumber()).getD1().getName()) && i.getNumber() == Squad.getConstructorByDriver(i.getName(), i.getNumber()).getD1().getNumber())
                i.setFantaF1points(2, false);
            if (parseInt(Squad.getConstructorByDriver(i.getName(), i.getNumber()).getD1().getQualifying_position()) > parseInt(Squad.getConstructorByDriver(i.getName(), i.getNumber()).getD2().getQualifying_position()) &&
                    i.getName().equals(Squad.getConstructorByDriver(i.getName(), i.getNumber()).getD2().getName()) && i.getNumber() == Squad.getConstructorByDriver(i.getName(), i.getNumber()).getD2().getNumber())
                i.setFantaF1points(2, false);

            i.setFantaF1points(tot, true);
        }
    }

    public void afterRace(List<Driver> race) {
        int tot = 0;
        int pos = 21;
        for (Driver i : race) {
            if (!i.getQualifying_position().equals("R")) {
                pos = parseInt(i.getQualifying_position());
                tot += 1;
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

            if (parseInt(Squad.getConstructorByDriver(i.getName(), i.getNumber()).getD1().getQualifying_position()) < parseInt(Squad.getConstructorByDriver(i.getName(), i.getNumber()).getD2().getQualifying_position()) &&
                    i.getName().equals(Squad.getConstructorByDriver(i.getName(), i.getNumber()).getD1().getName()) && i.getNumber() == Squad.getConstructorByDriver(i.getName(), i.getNumber()).getD1().getNumber())
                i.setFantaF1points(3, false);
            if (parseInt(Squad.getConstructorByDriver(i.getName(), i.getNumber()).getD1().getQualifying_position()) > parseInt(Squad.getConstructorByDriver(i.getName(), i.getNumber()).getD2().getQualifying_position()) &&
                    i.getName().equals(Squad.getConstructorByDriver(i.getName(), i.getNumber()).getD2().getName()) && i.getNumber() == Squad.getConstructorByDriver(i.getName(), i.getNumber()).getD2().getNumber())
                i.setFantaF1points(3, false);

            i.setFantaF1points(tot, true);
        }
    }

    public void comparison(List<Driver> race){

        int tot = 0;
        int posrace = 21, posq;
        Driver d;

        for(int i = 1; i < race.size() + 1; i++){
            d = race.get(i);
            if(!d.getRace_position().equals("R"))
                posrace = parseInt(d.getRace_position());

            posq = parseInt(d.getQualifying_position());

            if(posq < posrace && posq <= 10 && posrace != 21)
                tot -= Math.min((posrace - posq) * 2, 10);

            if(posq < posrace && posq > 10 && posrace != 21)
                tot -= Math.min((posrace - posq), 5);

            if(posq > posrace && posrace != 21) {
                tot += Math.max((posq - posrace) * 2, 10);
            }

            d.setFantaF1points(tot, true);
        }
    }

    @Override
    public void run() {
        race = rr.getRaceResult();
        qf = rr.getQualifyingResult();
        afterQualifying(qf);
        afterRace(race);
        comparison(race);
    }

}
