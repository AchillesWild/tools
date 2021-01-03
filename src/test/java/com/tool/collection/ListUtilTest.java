package com.tool.collection;

import java.util.*;
import java.util.stream.Collectors;

import com.achilles.wild.server.entity.info.Citizen;
import com.achilles.wild.server.entity.info.CitizenDetail;

public class ListUtilTest {


    private static List<Citizen> getCitizen(){
        List list= new ArrayList();
        Citizen citizen= new Citizen();
        citizen.setId(1l);
        citizen.setName("aa");
        list.add(citizen);
        Citizen citizen3= new Citizen();
        citizen3.setId(3l);
        citizen3.setName("bb");
        list.add(citizen3);
        Citizen citizen2= new Citizen();
        //citizen2.setId(2l);
        citizen2.setName("cc");
        list.add(citizen2);
        list.remove(2);
        Map map = new HashMap();
        map.put("1","");
        map.get("1");
        map.keySet();

        List linkedList = new LinkedList();
        linkedList.add(23);

        Set set = new HashSet();
        set.add(23);
        return list;
    }

    public static void main(String[] args) {
        Object result1 = null;
        //System.out.println(getCitizenIds());
        //result =getCitizenFilter();
        //System.out.println(result);
        //List<Long> list =new ArrayList<>();
        //list.add(1l);
        //list.add(2l);
        //List<Long> itemIdList = getCitizen().stream().filter(Objects::nonNull).map(var -> var.getId()).collect(Collectors.toList());
        List<Citizen> list = getCitizen();

        list.stream().forEach(var->var.setName("3333"));

        System.out.println(list);
        //getFilter2(list);
        //System.out.println(list);
       // System.out.println(getFilter(list));
        //System.out.println(getDitinct(Arrays.asList(1l,1l)));

        //String result="";
        //for (int i=0;i<3 ;i++) {
        //    if(i==0){
        //        result += "��"+(i+1)+"�� ����У��ʧ��,Ͷ��ʱ���Ͷ�Ž���ʱ�䲻���ǹ�ȥʱ��;";
        //        result+="\n";
        //    }
        //    if(i==2){
        //        result += "��"+(i+1)+"�� ����У��ʧ��,Ͷ��ʱ���Ͷ�Ž���ʱ�䲻���ǹ�ȥʱ��;";
        //        result+="\n";
        //    }
        //   // result+="<br />";
        //}
        //System.out.println(result);
    }


    private static Map<Long, String> getMap(List<Citizen> list){
        return list.stream().collect(Collectors.toMap(Citizen::getId, Citizen::getName, (key1 , key2)-> key2 ));
    }


    private static List<Long> getDitinct(List<Long> list){
       return list.stream().distinct().collect(Collectors.toList());
    }

    private static void getFilter2(List<Long> list){
        List<Long> list2 =Arrays.asList(1l,2l);
        list = list.stream().filter(var->{
            for (Long l:list2) {
                if (l==var){
                    return false;
                }
            }
            return  true;
        }).collect(Collectors.toList());

        //list.clear();
        //System.out.println(list);
        //return list;
    }

    private static List<Long> getFilter(List<Long> list){
        List<Long> list2 =Arrays.asList(1l,2l);
      return list.stream().filter(var->{
            for (Long l:list2) {
                if (l==var){
                    return false;
                }
            }
            return  true;
        }).collect(Collectors.toList());
         //System.out.println(list);
       //return list;
    }


    /**
     * ???????
     * @return
     */
    private static List<CitizenDetail> getCitizenDetail(List<Citizen> citizenList){
        List<CitizenDetail>  citizenDetailList =citizenList.stream().map(var->{
            CitizenDetail citizenDetail = new CitizenDetail();
            citizenDetail.setId(var.getId());
            return citizenDetail;
        }).collect(Collectors.toList());
        return citizenDetailList;
    }

    private static List<Citizen> getCitizenSetVal(){
        List<Citizen> list = getCitizen();
        list.stream().filter(var ->(var.getId()>2)).forEach(var->var.setName("test"));
        return list;
    }

    /**
     * ????id????
     * @return
     */
    private static Set<String> getFilterLanguages(){
        List<String> languages = Arrays.asList("Java", "html5","JavaScript", "C++", "hibernate", "PHP");
        Set langs = languages.stream().filter(var->var.contains("$")).collect(Collectors.toSet());
        return langs;
    }


    /**
     * ????id????
     * @return
     */
    private static List<Citizen> getCitizenFilter(){
        return getCitizen().stream().filter(var ->(var.getId()>10)).collect(Collectors.toList());
    }

    /**
     * ???id????
     * @return
     */
    private static List<Long> getCitizenIds(){
        return getCitizen().stream().map(var -> var.getId()).collect(Collectors.toList());
    }
}
