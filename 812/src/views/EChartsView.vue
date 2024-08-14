<template>
  <el-row>
    <el-col :span="12" :offset="6">
      <div id="newTypePie" style="width: 100%; height: 400px;"></div>
    </el-col>
  </el-row>
</template>

<script setup lang="ts">
  import { ElCol, ElRow } from 'element-plus'
  import * as echarts from "echarts"
  import { onMounted, ref } from 'vue'
  import http from '@/utils/http'

  const pie_data = ref([])
  const get_pie_data = () => {
    http.get("https://apifoxmock.com/m1/4895043-4550821-default/NewstypeStat")
      .then(res => {
        const data = res.data
        if (data.code == 200) {
          pie_data.value = data.data
          init_pie()
        }
      })
  }


  const init_pie = () => {
    var my_chart = echarts.init(document.getElementById("newTypePie"))

    let option = {
      tooltip: { trigger: 'item' },
      legend: {
        top: '5%',
        left: 'center'
      },
      series: [
        {
          name: '该类别新闻数量',
          type: 'pie',
          radius: ['40%', '70%'],
          avoidLabelOverlap: false,
          ItemStyle: {
            borderRadius: 10,
            borderColor: '#fff',
            borderWidth: 2
          },
          label: {
            show: false,
            Position: 'center'
          },
          emphasis: {
            label: {
              show: true,
              fontSize: 40,
              fontWeight: 'bold'
            }
          },
          labelLine: {
            show: false
          },
          data: pie_data.value
        }
      ]
    }
    my_chart.setOption(option)
  }

  onMounted(() => {
    get_pie_data()
  })
</script>