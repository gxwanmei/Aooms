<template>
    <el-form
            ref="form"
            :inline="true"
            :model="form"
            size="mini"
            label-width="70px"
            style="margin-bottom: -18px;">

        <el-form-item label="状态">
            <el-select v-model="form.status" placeholder="状态" @change="handleFormSubmit()" style="width: 100px;">
                <el-option label="全部" value=""/>
                <el-option label="正常" value="Y"/>
                <el-option label="禁用" value="N"/>
            </el-select>
        </el-form-item>

        <el-form-item label="名称">
            <el-input v-model="form.role_name" placeholder="角色名称" style="width: 100px;"/>
        </el-form-item>

        <el-form-item label="编号">
            <el-input v-model="form.role_code" placeholder="角色编号" style="width: 120px;"/>
        </el-form-item>

        <el-form-item>
            <el-button type="primary" @click="handleFormSubmit()">
                <d2-icon name="search"/>查询
            </el-button>
        </el-form-item>

        <el-form-item>
            <el-button @click="handleFormReset">
                <d2-icon name="refresh"/>重置
            </el-button>
        </el-form-item>

    </el-form>
</template>

<script>
export default {
    data() {
        return {
            form: {
                status: 'Y'
            }
        }
    },
    mounted() {

    },
    methods: {
        handleFormSubmit() {
            this.$emit('tableLoad', this.form , true);
        },
        handleFormReset() {
            this.form = {status: 'Y'};
            this.$refs.form.resetFields();
        }
    }
}
</script>
