class SQL {
    Map<String, List<List<String>>> map = new HashMap<>();
    public SQL(List<String> names, List<Integer> columns) {
        for(String name: names){
            List<List<String>> list = new ArrayList<>();
            map.put(name, list);
        }
    }
    
    public void insertRow(String name, List<String> row) {
        List<List<String>> targetList = map.get(name);
        targetList.add(row);
        map.put(name, targetList);
    }
    
    public void deleteRow(String name, int rowId) {
        List<List<String>> targetList = map.get(name);
        targetList.set(rowId-1, new ArrayList<>());
        map.put(name, targetList);
    }
    
    public String selectCell(String name, int rowId, int columnId) {
        List<List<String>> targetList = map.get(name);
        List<String> targetRow = targetList.get(rowId-1);
        int targetIndex = columnId-1;
        return targetRow.get(targetIndex);
    }
}

/**
 * Your SQL object will be instantiated and called as such:
 * SQL obj = new SQL(names, columns);
 * obj.insertRow(name,row);
 * obj.deleteRow(name,rowId);
 * String param_3 = obj.selectCell(name,rowId,columnId);
 */