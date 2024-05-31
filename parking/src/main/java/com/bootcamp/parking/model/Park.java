package com.bootcamp.parking.model;

import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Park {
  @JsonProperty(value = "park_Id")
  int parkId;
  String name;
  String nature;
  @JsonProperty(value = "carpark_Type")
  String type;
  Address address;
      public static class Address{
        HashMap<String, String> map = new HashMap<>();
        String buildingName;
        String streetName;
        String buildingNo;
        String floor;
        String subDistrict;
        String dcDistrict;
        String region;
      }
      
  String displayAddress;
  String district;
  double latitude;
  double longitude;
  String contactNo;
  RenditionUrls renditionUrls;
    public static class RenditionUrls{
      String square;
      String thumbnail;
      String banner;
  }

  String website;
  String opening_status;
  OpeningHours openingHours
    public static class OpeningHours{
      String weekdays; 
       Boolean excludePublicHoliday;
    String periodStart;
    String periodEnd;
    }
    
    @JsonProperty(value = gracePeriods)
  List<GracePeriods> gracePeriods;
    public static class
      {
          "minutes": 10
      }
  ],
  "heightLimits": [
      {
          "height": 2
      }
  ],
  "facilities": [
      "disabilities",
      "evCharger"
  ],
  "paymentMethods": [
      "octopus",
      "visa"
  ],
  "privateCar": {
      "hourlyCharges": [
          {
              "weekdays": [
                  "MON",
                  "TUE",
                  "WED",
                  "THU",
                  "FRI"
              ],
              "excludePublicHoliday": true,
              "periodStart": "07:00",
              "periodEnd": "23:00",
              "price": 15,
              "type": "hourly",
              "covered": "covered",
              "usageMinimum": 1,
              "remark": ""
          },
          {
              "weekdays": [
                  "SAT",
                  "SUN",
                  "PH"
              ],
              "excludePublicHoliday": false,
              "periodStart": "07:00",
              "periodEnd": "23:00",
              "price": 20,
              "usageMinimum": 1,
              "type": "hourly",
              "covered": "covered",
              "remark": ""
          }
      ],
      "spaceUNL": 0,
      "spaceEV": 0,
      "spaceDIS": 0,
      "space": 112
  },
  "LGV": {
      "spaceUNL": 0,
      "spaceEV": 0,
      "spaceDIS": 0,
      "space": 0
  },
  "HGV": {
      "spaceUNL": 0,
      "spaceEV": 0,
      "spaceDIS": 0,
      "space": 0
  },
  "coach": {
      "spaceUNL": 0,
      "spaceEV": 0,
      "spaceDIS": 0,
      "space": 0
  },
  "motorCycle": {
      "spaceUNL": 0,
      "spaceEV": 0,
      "spaceDIS": 0,
      "space": 0
  },
  "creationDate": "2016-08-16 10:03:56",
  "modifiedDate": "2024-01-03 13:28:25",
  "publishedDate": "2018-12-12 12:22:47",
  "lang": "en_US"
},
}
