package com.example.cpuselectionasistant.utils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ServerAPI {
    @POST("/api/predict_cpu")
    public Call<Predict> getPredict(@Body UserChoose choose);


    class Predict {

        @SerializedName("cpu_series")
        @Expose
        private String cpuSeries;

        public String getCpuSeries() {
            return cpuSeries;
        }

        public void setCpuSeries(String cpuSeries) {
            this.cpuSeries = cpuSeries;
        }

    }

    class UserChoose {

        @SerializedName("Vertical_Segment")
        @Expose
        private String verticalSegment;
        @SerializedName("Status")
        @Expose
        private String status;
        @SerializedName("Launch_Date")
        @Expose
        private String launchDate;
        @SerializedName("Lithography")
        @Expose
        private Double lithography;
        @SerializedName("nb_of_Cores")
        @Expose
        private Double nbOfCores;
        @SerializedName("Processor_Base_Frequency")
        @Expose
        private Double processorBaseFrequency;
        @SerializedName("Cache")
        @Expose
        private Double cache;
        @SerializedName("TDP")
        @Expose
        private Double tDP;
        @SerializedName("T")
        @Expose
        private Integer t;
        @SerializedName("Intel_Virtualization_Technology")
        @Expose
        private String intelVirtualizationTechnology;
        @SerializedName("Intel_Turbo_Boost_Technology")
        @Expose
        private String intelTurboBoostTechnology;
        @SerializedName("Embedded_Options_Available")
        @Expose
        private String embeddedOptionsAvailable;

        public String getVerticalSegment() {
            return verticalSegment;
        }

        public void setVerticalSegment(String verticalSegment) {
            this.verticalSegment = verticalSegment;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getLaunchDate() {
            return launchDate;
        }

        public void setLaunchDate(String launchDate) {
            this.launchDate = launchDate;
        }

        public Double getLithography() {
            return lithography;
        }

        public void setLithography(Double lithography) {
            this.lithography = lithography;
        }

        public Double getNbOfCores() {
            return nbOfCores;
        }

        public void setNbOfCores(Double nbOfCores) {
            this.nbOfCores = nbOfCores;
        }

        public Double getProcessorBaseFrequency() {
            return processorBaseFrequency;
        }

        public void setProcessorBaseFrequency(Double processorBaseFrequency) {
            this.processorBaseFrequency = processorBaseFrequency;
        }

        public Double getCache() {
            return cache;
        }

        public void setCache(Double cache) {
            this.cache = cache;
        }

        public Double getTDP() {
            return tDP;
        }

        public void setTDP(Double tDP) {
            this.tDP = tDP;
        }

        public Integer getT() {
            return t;
        }

        public void setT(Integer t) {
            this.t = t;
        }

        public String getIntelVirtualizationTechnology() {
            return intelVirtualizationTechnology;
        }

        public void setIntelVirtualizationTechnology(String intelVirtualizationTechnology) {
            this.intelVirtualizationTechnology = intelVirtualizationTechnology;
        }

        public String getIntelTurboBoostTechnology() {
            return intelTurboBoostTechnology;
        }

        public void setIntelTurboBoostTechnology(String intelTurboBoostTechnology) {
            this.intelTurboBoostTechnology = intelTurboBoostTechnology;
        }

        public String getEmbeddedOptionsAvailable() {
            return embeddedOptionsAvailable;
        }

        public void setEmbeddedOptionsAvailable(String embeddedOptionsAvailable) {
            this.embeddedOptionsAvailable = embeddedOptionsAvailable;
        }

    }
}