<template>
    <v-card outlined>
        <v-card-title>
            ReceiveReport
        </v-card-title>

        <v-card-text>
            <String label="UserId" v-model="value.userId" :editMode="editMode"/>
            <Number label="Longitude" v-model="value.longitude" :editMode="editMode"/>
            <Number label="Latitude" v-model="value.latitude" :editMode="editMode"/>
            <String label="Description" v-model="value.description" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="receiveReport"
            >
                ReceiveReport
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'ReceiveReportCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.userId = '';
            this.value.longitude = 0;
            this.value.latitude = 0;
            this.value.description = '';
        },
        watch: {
        },
        methods: {
            receiveReport() {
                this.$emit('receiveReport', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

