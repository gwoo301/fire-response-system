<template>
    <div>
        <v-list two-line v-if="list.length > 0">
            <v-list-item-group 
                    v-model="selected" 
                    color="primary"
                    @change="select"
            >
                <v-list-item v-for="(item, idx) in list" :key="idx">
                    <template v-slot:default="{ active }">
                        <v-list-item-avatar color="primary-darker-1">
                        </v-list-item-avatar>
                        
                        <v-list-item-content>
                            <v-list-item-title>
                            </v-list-item-title>
                            <v-list-item-subtitle>
                                UserAlarmId :  {{item.userAlarmId }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                UserId :  {{item.userId }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                AlarmId :  {{item.alarmId }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                EventId :  {{item.eventId }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                Longitude :  {{item.longitude }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                Latitude :  {{item.latitude }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                CreatedAt :  {{item.createdAt }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                ReportId :  {{item.reportId }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                Content :  {{item.content }}
                            </v-list-item-subtitle>
                        </v-list-item-content>

                        <v-list-item-action>
                            <v-checkbox :input-value="active" color="primary-darker-1"></v-checkbox>
                        </v-list-item-action>
                    </template>
                </v-list-item>
            </v-list-item-group>
        </v-list>
    </div>
</template>


<script>
    const axios = require('axios').default;

    export default {
        name: 'NotificationUserAlarmPicker',
        props: {
            value: [String, Object, Array, Number, Boolean],
        },
        data: () => ({
            list: [],
            selected: null,
        }),
        async created() {
            var me = this;
            var temp = await axios.get(axios.fixUrl('/userAlarms'))
            if(temp.data) {
                me.list = temp.data._embedded.userAlarms;
            }

            if(me.value && typeof me.value == "object" && Object.values(me.value)[0]) {
                var id = Object.values(me.value)[0];
                var tmpValue = await axios.get(axios.fixUrl('/userAlarms/' + id))
                if(tmpValue.data) {
                    var val = tmpValue.data
                    me.list.forEach(function(item, idx) {
                        if(item.name == val.name) {
                            me.selected = idx
                        }
                    })
                }
            }
        },
        methods: {
            select(val) {
                var obj = {}
                if(val != undefined) {
                    var arr = this.list[val]._links.self.href.split('/');
                    obj['userAlarmId'] = arr[4]; 
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    this.$emit('selected', obj);
                }
            },
        },
    };
</script>

