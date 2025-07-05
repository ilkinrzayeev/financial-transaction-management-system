import React from 'react';
import { useFormik } from 'formik';
import * as Yup from 'yup';
import { createCustomer } from '../services/customerService';

const CustomerForm = ({ onSuccess }) => {
    const formik = useFormik({
        initialValues: {
            firstName: '',
            lastName: '',
            email: '',
        },
        validationSchema: Yup.object({
            firstName: Yup.string().required('First name is required'),
            lastName: Yup.string().required('Last name is required'),
            email: Yup.string().email('Invalid email').required('Email is required'),
        }),
        onSubmit: async (values, { resetForm, setSubmitting, setStatus }) => {
            try {
                await createCustomer(values);
                setStatus({ success: 'Customer created successfully!' });
                resetForm();
                if (onSuccess) onSuccess();
            } catch (error) {
                setStatus({ error: error.response?.data?.error || 'An error occurred' });
            } finally {
                setSubmitting(false);
            }
        },
    });

    return (
        <form onSubmit={formik.handleSubmit}>
            <div>
                <input
                    name="firstName"
                    placeholder="First Name"
                    value={formik.values.firstName}
                    onChange={formik.handleChange}
                />
                {formik.touched.firstName && formik.errors.firstName && (
                    <div style={{ color: 'red' }}>{formik.errors.firstName}</div>
                )}
            </div>
            <div>
                <input
                    name="lastName"
                    placeholder="Last Name"
                    value={formik.values.lastName}
                    onChange={formik.handleChange}
                />
                {formik.touched.lastName && formik.errors.lastName && (
                    <div style={{ color: 'red' }}>{formik.errors.lastName}</div>
                )}
            </div>
            <div>
                <input
                    name="email"
                    placeholder="Email"
                    value={formik.values.email}
                    onChange={formik.handleChange}
                />
                {formik.touched.email && formik.errors.email && (
                    <div style={{ color: 'red' }}>{formik.errors.email}</div>
                )}
            </div>
            <button type="submit" disabled={formik.isSubmitting}>Add Customer</button>
            {formik.status?.success && <div style={{ color: 'green' }}>{formik.status.success}</div>}
            {formik.status?.error && <div style={{ color: 'red' }}>{formik.status.error}</div>}
        </form>
    );
};

export default CustomerForm;