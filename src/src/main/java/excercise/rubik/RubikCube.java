package excercise.rubik;

public class RubikCube {

    private Face main, left, right, top, bottom, back;

    public RubikCube() {
        main = new Face(1);
        left = new Face(2);
        right = new Face(3);
        back = new Face(4);
        top = new Face(5);
        back = new Face(6);
    }

    public void turnRowToRight(int row) throws Exception{
        int[] mainTopRow = main.getRow(row);
        main.setRow(row, left.getRow(row));
        left.setRow(row, back.getRow(row));
        back.setRow(row, right.getRow(row));
        right.setRow(row, mainTopRow);
        if(row == 0){
            top.turnAntiClockWise();
        } else if(row == 3) {
            bottom.turnClockWise();
        }
    }



}
